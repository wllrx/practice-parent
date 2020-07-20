package cn.wllsrx.zoe.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zoe
 **/
@Data
@ApiModel("新增影厅信息传输对象")
public class HallDTO {

    @ApiModelProperty(value = "影院编号", required = true)
    private Integer cinemaId;

    @ApiModelProperty(value = "电影编号", required = true)
    private Integer filmId;

    @ApiModelProperty(value = "开始时间", required = true)
    private Date beginTime;

    @ApiModelProperty(value = "结束时间", required = true)
    private Date endTime;

    @ApiModelProperty(value = "放映厅类型编号", required = true)
    private Integer hallId;

    @ApiModelProperty(value = "放映厅名称", required = true)
    private String hallName;

    @ApiModelProperty(value = "票价", required = true)
    private BigDecimal price;
}
