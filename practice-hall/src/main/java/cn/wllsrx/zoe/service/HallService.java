package cn.wllsrx.zoe.service;

import cn.gjing.tools.common.result.PageResult;
import cn.gjing.tools.common.util.BeanUtils;
import cn.wllsrx.zoe.domain.dto.HallDTO;
import cn.wllsrx.zoe.domain.entity.Field;
import cn.wllsrx.zoe.domain.vo.HallVO;
import cn.wllsrx.zoe.mapper.HallMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zoe
 **/
@Service
public class HallService {

    @Resource
    private HallMapper hallMapper;

    /**
     * 添加影厅信息
     * @param hallDTO 影厅信息
     */
    public void insertHall(HallDTO hallDTO){
        this.hallMapper.insert(BeanUtils.copyProperties(hallDTO, Field.class));
    }

    /**
     * 分页查询影片播放厅列表
     * @param page 分页
     * @param hallName 播放厅名称
     * @return List<HallVO>
     */
    public PageResult<List<HallVO>> selectHall(Page<HallVO> page, String hallName){
        IPage<HallVO> hallPage = this.hallMapper.selectHall(page, hallName);
        return PageResult.of(hallPage.getRecords(), hallPage.getPages(), hallPage.getCurrent(), hallPage.getSize(),
                hallPage.getTotal());
    }
}
