package cn.wllsrx.zoe.controller;

import cn.gjing.tools.common.result.PageResult;
import cn.gjing.tools.common.valid.NotNull;
import cn.wllsrx.zoe.domain.dto.CinemaDTO;
import cn.wllsrx.zoe.domain.vo.CinemaVO;
import cn.wllsrx.zoe.exception.ServiceException;
import cn.wllsrx.zoe.service.CinemaService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@Api(tags = "影院操作")
public class CinemaController {

    @Resource
    private CinemaService cinemaService;

    @PostMapping("/cinema")
    @ApiOperation("添加影院")
    public ResponseEntity<String> insertCinema(@RequestBody CinemaDTO cinemaDTO) {
        this.cinemaService.insertCinema(cinemaDTO);
        return ResponseEntity.ok("添加成功!");
    }


    public ResponseEntity<PageResult<List<CinemaVO>>> fallbackMethod(@NotNull(message = "page页数不能为空!") Integer page,
                                                                     @NotNull(message = "size每页条数不能为空!") Integer size, String cinemaName) {

        throw new ServiceException("进入容错降级处理");

    }


    @HystrixCommand(fallbackMethod = "fallbackMethod",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
            },
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "1"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
                    @HystrixProperty(name = "keepAliveTimeMinutes", value = "1000"),
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "8"),
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1500")
            })
    @GetMapping("/cinema")
    @ApiOperation("分页查询影院")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页条数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "cinemaName", value = "影院名称", dataType = "String", paramType = "query")
    })
    public ResponseEntity<PageResult<List<CinemaVO>>> selectCinema(@NotNull(message = "page页数不能为空!") Integer page,
                                                                   @NotNull(message = "size每页条数不能为空!") Integer size, String cinemaName) {
        return ResponseEntity.ok(this.cinemaService.selectCinema(new Page<>(page, size), cinemaName));
    }
}
