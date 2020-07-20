package cn.wllsrx.zoe.service;

import cn.gjing.tools.common.result.PageResult;
import cn.gjing.tools.common.util.BeanUtils;
import cn.wllsrx.zoe.domain.dto.CinemaDTO;
import cn.wllsrx.zoe.domain.entity.Cinema;
import cn.wllsrx.zoe.domain.vo.CinemaVO;
import cn.wllsrx.zoe.exception.ServiceException;
import cn.wllsrx.zoe.mapper.CinemaMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zoe
 **/
@Service
public class CinemaService {

    @Resource
    private CinemaMapper cinemaMapper;

    /**
     * 影院添加
     * @param cinemaDTO 影院信息
     */
    public void insertCinema(CinemaDTO cinemaDTO){
        QueryWrapper<Cinema> wrapper = new QueryWrapper<>();
        wrapper.eq("cinema_name",cinemaDTO.getCinemaName());
        Cinema cinema = this.cinemaMapper.selectOne(wrapper);
        if (cinema!=null){
            throw new ServiceException("影院已存在!");
        }
        Cinema cinema1 = BeanUtils.copyProperties(cinemaDTO, Cinema.class);
        this.cinemaMapper.insert(cinema1);
    }

    /**
     * 分页查询影院
     * @param page 分页
     * @param cinemaName 影院名称
     * @return 影院信息
     */
    public PageResult<List<CinemaVO>> selectCinema(Page<CinemaVO> page,String cinemaName){
        IPage<CinemaVO> cinemaPage = this.cinemaMapper.selectCinema(page, cinemaName);
        return PageResult.of(cinemaPage.getRecords(), cinemaPage.getPages(), cinemaPage.getCurrent(), cinemaPage.getSize(),
                cinemaPage.getTotal());
    }
}
