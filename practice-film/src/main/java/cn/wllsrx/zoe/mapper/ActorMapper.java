package cn.wllsrx.zoe.mapper;

import cn.wllsrx.zoe.domain.entity.Actor;
import cn.wllsrx.zoe.domain.vo.ActorVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zoe
 **/
@Mapper
public interface ActorMapper extends BaseMapper<Actor> {

    /**
     * 查询演员
     * @return ActorVO
     */
    List<ActorVO> selectActors();
}
