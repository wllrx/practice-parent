package cn.wllsrx.zoe.service;

import cn.gjing.tools.common.result.PageResult;
import cn.gjing.tools.common.util.BeanUtils;
import cn.gjing.tools.common.util.EncryptionUtils;
import cn.wllsrx.zoe.entity.Account;
import cn.wllsrx.zoe.domain.vo.AccountVO;
import cn.wllsrx.zoe.exception.ServiceException;
import cn.wllsrx.zoe.mapper.AccountMapper;
import cn.wllsrx.zoe.utils.JwtTokenUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zoe
 **/
@Service
public class AccountService{

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AmqpTemplate rabbitTemplate;

    /**
     * 添加账户
     */
    public void saveAccount() {
        List<Account> accounts = new ArrayList<>(16);
        for (int i = 0; i < 10; i++) {
            Account account = Account.builder()
                    .userName("admin" + i)
                    .userPwd(EncryptionUtils.encodeMd5("admin" + i))
                    .userPhone("1256985544" + i)
                    .build();
            accounts.add(account);
            this.accountMapper.insert(account);
        }
        List<AccountVO> accountList = new ArrayList<>();
        for (Account account : accounts) {
            accountList.add(BeanUtils.copyProperties(account, AccountVO.class));
        }
        this.rabbitTemplate.convertAndSend("test", accountList);
    }

    /**
     * 分页查询用户列表
     *
     * @param page     分页
     * @param userName 账户名
     * @return 账户信息
     */
    public PageResult<List<Account>> selectAccounts(Page<Account> page, String userName) {
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.likeRight("user_name", userName);
        Page<Account> accountPage = this.accountMapper.selectPage(page, wrapper);
        return PageResult.of(accountPage.getRecords(), accountPage.getPages(), accountPage.getCurrent(), accountPage.getSize(),
                accountPage.getTotal());
    }


    /**
     * 登录
     *
     * @param userName 用户名
     * @param userPwd  密码
     * @return map
     */
    public Map<String, String> login(String userName, String userPwd) {
        Map<String, String> map = new HashMap<>(16);
        QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        Account account = this.accountMapper.selectOne(wrapper);
        if (account == null) {
            throw new ServiceException("当前用户不存在!");
        }
        if (!EncryptionUtils.encodeMd5(userPwd).equals(account.getUserPwd())) {
            throw new ServiceException("密码不正确,请重新输入!");
        }
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String randomKey = jwtTokenUtil.getRandomKey();
        map.put("randomKey", randomKey);
        map.put("token", jwtTokenUtil.generateToken(userName, randomKey));
        return map;
    }
}
