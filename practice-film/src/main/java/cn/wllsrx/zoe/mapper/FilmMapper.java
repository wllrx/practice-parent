package cn.wllsrx.zoe.mapper;

import cn.wllsrx.zoe.domain.entity.Film;
import cn.wllsrx.zoe.domain.vo.FilmVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zoe
 **/
@Mapper
public interface FilmMapper extends BaseMapper<Film> {

    /**
     * 根据电影名称查询电影信息
     * @param filmName 电影名称
     * @return 电影信息
     */
    @Select("select * from film where film_name = #{filmName}")
    Film selectFilmByFilmName(String filmName);

    /**
     * 根据id查询电影信息
     * @param id id
     * @return  电影信息
     */
    FilmVO selectFilms(Integer id);

    /**
     * 分页查询影片列表
     * @param page 分页
     * @param id id
     * @return 影片列表
     */
    IPage<FilmVO> selectFilms(Page<FilmVO> page,Integer id);
}
