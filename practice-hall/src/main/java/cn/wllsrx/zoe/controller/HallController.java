package cn.wllsrx.zoe.controller;

import cn.gjing.tools.common.result.PageResult;
import cn.gjing.tools.common.valid.NotNull;
import cn.wllsrx.zoe.domain.dto.HallDTO;
import cn.wllsrx.zoe.domain.vo.HallVO;
import cn.wllsrx.zoe.service.HallService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zoe
 **/
@RestController
@Api(tags = "影厅操作")
public class HallController {

    @Resource
   private HallService hallService;

    @PostMapping("/hall")
    @ApiOperation("新增影片播放厅信息")
    public ResponseEntity<String> insertHall(@RequestBody HallDTO hallDTO){
        this.hallService.insertHall(hallDTO);
        return ResponseEntity.ok("添加成功");
    }

    @GetMapping("/hall")
    @ApiOperation("影片播放厅列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "hallName", value = "影厅名称", dataType = "String", paramType = "query")
    })
    public ResponseEntity<PageResult<List<HallVO>>> selectHall(@NotNull(message = "page页数不能为空!") Integer page,
                                                               @NotNull(message = "size每页条数不能为空!") Integer size,String hallName){
        return ResponseEntity.ok(this.hallService.selectHall(new Page<>(page,size),hallName));
    }
}
