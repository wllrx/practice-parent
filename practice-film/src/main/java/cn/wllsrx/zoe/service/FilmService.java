package cn.wllsrx.zoe.service;

import cn.gjing.tools.common.result.PageResult;
import cn.gjing.tools.common.util.BeanUtils;
import cn.wllsrx.zoe.domain.dto.FilmDTO;
import cn.wllsrx.zoe.domain.entity.Film;
import cn.wllsrx.zoe.domain.entity.FilmInfo;
import cn.wllsrx.zoe.domain.vo.FilmVO;
import cn.wllsrx.zoe.exception.ServiceException;
import cn.wllsrx.zoe.mapper.FilmInfoMapper;
import cn.wllsrx.zoe.mapper.FilmMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zoe
 **/
@Service
public class FilmService {

    @Resource
    private FilmMapper filmMapper;

    @Resource
    private FilmInfoMapper infoMapper;


    /**
     * 添加影片
     *
     * @param filmDTO 影片信息
     */
    @Transactional(rollbackFor = ServiceException.class)
    public void insertFilm(FilmDTO filmDTO) {
        Film film = this.filmMapper.selectFilmByFilmName(filmDTO.getFilmName());
        if (film != null) {
            throw new ServiceException("电影已存在!");
        }
        Film film1 = BeanUtils.copyProperties(filmDTO, Film.class, "id", "createTime", "updateTime");
        this.filmMapper.insert(film1);
        FilmInfo filmInfo = BeanUtils.copyProperties(filmDTO, FilmInfo.class, "id", "createTime", "updateTime");
        this.infoMapper.insert(filmInfo);
    }

    /**
     * 根据影片id查询影片信息
     * @param id id
     * @return 影片信息
     */
    public FilmVO selectFilms(Integer id){
        Film film = this.filmMapper.selectById(id);
        if (film == null){
            throw new ServiceException("影片不存在!");
        }
        return this.filmMapper.selectFilms(id);
    }

    /**
     * 分页查询影片
     * @param page 分页
     * @param id id
     * @return FilmVO
     */
    public PageResult<List<FilmVO>> selectFilms(Page<FilmVO> page,Integer id){
        IPage<FilmVO> filmPage = this.filmMapper.selectFilms(page, id);
        return PageResult.of(filmPage.getRecords(), filmPage.getPages(), filmPage.getCurrent(), filmPage.getSize(),
                filmPage.getTotal());
    }
}
