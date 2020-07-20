package cn.wllsrx.zoe.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zoe
 **/
@Data
@ApiModel("影片播放厅返回数据")
public class HallVO {

    @ApiModelProperty("影院名称")
    private String cinemaName;

    @ApiModelProperty("放映厅名称")
    private String hallName;

    @ApiModelProperty("影片名称")
    private String filmName;

    @ApiModelProperty("开始时间")
    private Date beginTime;

    @ApiModelProperty("结束时间")
    private Date endTime;

    @ApiModelProperty("票价")
    private BigDecimal price;

    @ApiModelProperty("影厅类型编号")
    private Integer hallId;


}
