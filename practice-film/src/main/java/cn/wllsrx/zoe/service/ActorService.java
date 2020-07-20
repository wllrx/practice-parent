package cn.wllsrx.zoe.service;

import cn.gjing.tools.common.result.PageResult;
import cn.wllsrx.zoe.domain.entity.Actor;
import cn.wllsrx.zoe.domain.vo.ActorVO;
import cn.wllsrx.zoe.mapper.ActorMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zoe
 **/
@Service
public class ActorService {

    @Resource
    private ActorMapper actorMapper;

    /**
     * 分页查询演员列表
     *
     * @param page      分页
     * @param actorName 演员名称
     * @return 演员信息
     */
    public PageResult<List<Actor>> selectActor(Page<Actor> page, String actorName) {
        QueryWrapper<Actor> wrapper = new QueryWrapper<>();
        wrapper.eq("actor_name", actorName);
        wrapper.orderByDesc("id");
        Page<Actor> actorPage = this.actorMapper.selectPage(page, wrapper);
        return PageResult.of(actorPage.getRecords(), actorPage.getPages(), actorPage.getCurrent(), actorPage.getSize(),
                actorPage.getTotal());
    }

    /**
     * 添加影片时 演员编号和角色名称做下拉
     * @return actor
     */
    public List<ActorVO> selectActorInfo(){
        return this.actorMapper.selectActors();
    }
}
