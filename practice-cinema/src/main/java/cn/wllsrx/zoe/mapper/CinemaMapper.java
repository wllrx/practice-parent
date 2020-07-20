package cn.wllsrx.zoe.mapper;

import cn.wllsrx.zoe.domain.entity.Cinema;
import cn.wllsrx.zoe.domain.vo.CinemaVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zoe
 **/
@Mapper
public interface CinemaMapper extends BaseMapper<Cinema> {

    /**
     * 分页查询影院
     * @param page 分页
     * @param cinemaName 影院名称
     * @return 影院信息
     */
    IPage<CinemaVO> selectCinema(Page<CinemaVO> page,String cinemaName);
}
