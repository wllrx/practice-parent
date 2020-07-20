package cn.wllsrx.zoe.controller;

import cn.gjing.tools.common.result.PageResult;
import cn.gjing.tools.common.valid.NotNull;
import cn.wllsrx.zoe.domain.entity.Actor;
import cn.wllsrx.zoe.domain.vo.ActorVO;
import cn.wllsrx.zoe.service.ActorService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zoe
 **/
@RestController
@Api(tags = "演员操作")
public class ActorController {

    @Resource
    private ActorService actorService;

    @GetMapping("/actor")
    @ApiOperation("分页查询演员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "actorName", value = "演员名称", dataType = "String", paramType = "query")
    })
    public ResponseEntity<PageResult<List<Actor>>> selectActor(@NotNull(message = "page页数不能为空!") Integer page,
                                                               @NotNull(message = "size每页条数不能为空!") Integer size,
                                                               String actorName){
        return ResponseEntity.ok(this.actorService.selectActor(new Page<>(page,size),actorName));
    }

    @GetMapping("/actor_info")
    @ApiOperation("查询演员信息下拉框使用")
    public ResponseEntity<List<ActorVO>> selectActorInfo(){
        return ResponseEntity.ok(this.actorService.selectActorInfo());
    }


}
