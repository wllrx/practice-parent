package cn.wllsrx.zoe.controller;

import cn.gjing.tools.common.result.PageResult;
import cn.wllsrx.zoe.domain.entity.Account;
import cn.wllsrx.zoe.service.AccountEsService;
import cn.wllsrx.zoe.service.AccountService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zoe
 **/
@RestController
@Api(tags = "用户操作")
public class AccountController {


    @Resource
    private AccountService accountService;

    @Resource
    private AccountEsService esService;



    @GetMapping("/account")
    @ApiOperation("分页查询账户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "userName", value = "账户名", dataType = "String", paramType = "query")
    })
    public ResponseEntity<PageResult<List<Account>>> selectAccount(Integer page, Integer size, String userName){
        return ResponseEntity.ok(this.accountService.selectAccounts(new Page<>(page,size),userName));
    }

    @PostMapping("/accounts")
    @ApiOperation("添加账户")
    public ResponseEntity<String> saveAccount(){
        this.accountService.saveAccount();
        return ResponseEntity.ok("账户添加成功!");
    }

    @PostMapping("/es_accounts")
    @ApiOperation("es添加账户")
    public ResponseEntity<String> saveAccountEs(){
        this.esService.saveAccount();
        return ResponseEntity.ok("账户添加成功!");
    }

    @GetMapping("/es_account")
    @ApiOperation("es查询账户")
    @ApiImplicitParam(name = "userName", value = "账户名", dataType = "String", paramType = "query")
    public ResponseEntity<List<Account>> findAccounts(String userName){
        return ResponseEntity.ok(esService.findAccount(userName));
    }

    @DeleteMapping("/es_account")
    @ApiOperation("es删除所有账户")
    public ResponseEntity<String> deleteAccounts(){
        this.esService.deleteAccount();
        return ResponseEntity.ok("删除成功");
    }

    @PostMapping("/public/account")
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "账户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "userPwd", value = "账户密码", required = true, dataType = "String", paramType = "query")
    })
    public ResponseEntity<Map<String,String>> login(String userName,String userPwd){
        return ResponseEntity.ok(this.accountService.login(userName, userPwd));
    }

    /*@GetMapping("/test")
    @RequirePermissions("add")
    @RequireRoles("admin")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/token")
    public ResponseEntity<String> token(){
//        AuthorizationInfo info = new AuthorizationInfo();
//        info.setSalt("65463");
//        info.setType(SignatureAlgorithm.HS256);
//        TokenAssistant tokenAssistant = new TokenAssistant(info);


        Map<String,Object> map = new HashMap<>(16);
        map.put("salt","125452");
        map.put("type", SignatureAlgorithm.HS256);
        String token = assistant.createToken(map);
        Claims claims = assistant.parseToken(token);
        return ResponseEntity.ok(token+claims.toString());
    }*/

    @GetMapping("/aggregate")
    @ApiOperation("aggregate")
    public ResponseEntity<String> aggregateQuery(String ColumnName){
        this.esService.aggregateQuery(ColumnName);
        return ResponseEntity.ok("");
    }

    @GetMapping("/avg")
    @ApiOperation("avg")
    public ResponseEntity<String> aggregateAvg(String columnName){
        this.esService.aggregateAvg(columnName);
        return ResponseEntity.ok("");
    }


}
