package cn.wllsrx.zoe.mapper;

import cn.wllsrx.zoe.domain.entity.Field;
import cn.wllsrx.zoe.domain.vo.HallVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zoe
 **/
@Mapper
public interface HallMapper extends BaseMapper<Field> {

    /**
     * 分页查询影片播放厅列表
     * @param page 分页
     * @param hallName 播放厅名称
     * @return HallVO
     */
    IPage<HallVO> selectHall(Page<HallVO> page,String hallName);
}
