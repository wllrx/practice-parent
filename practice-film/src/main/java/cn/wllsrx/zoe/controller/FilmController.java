package cn.wllsrx.zoe.controller;

import cn.gjing.tools.common.result.PageResult;
import cn.gjing.tools.common.valid.Json;
import cn.gjing.tools.common.valid.NotNull;
import cn.wllsrx.zoe.domain.dto.FilmDTO;
import cn.wllsrx.zoe.domain.vo.FilmVO;
import cn.wllsrx.zoe.service.FilmService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zoe
 **/
@RestController
@Api(tags = "影片操作")
public class FilmController {

    @Resource
    private FilmService filmService;

    @PostMapping("/film")
    @ApiOperation("添加影片")
    public ResponseEntity<String> insertFilm(@RequestBody @Json FilmDTO filmDTO) {
        this.filmService.insertFilm(filmDTO);
        return ResponseEntity.ok("添加成功!");
    }

    @GetMapping("/film/{id}")
    @ApiOperation("根据id查询影片详情")
    public ResponseEntity<FilmVO> selectFilm(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.filmService.selectFilms(id));
    }

    @GetMapping("/films")
    @ApiOperation("分页查询影片列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "id", value = "id", dataType = "int", paramType = "query")
    })
    public ResponseEntity<PageResult<List<FilmVO>>> selectFilms(@NotNull(message = "page页数不能为空!") Integer page,
                                                                @NotNull(message = "size每页条数不能为空!") Integer size,Integer id) {
        return ResponseEntity.ok(this.filmService.selectFilms(new Page<>(page,size),id));
    }
}
