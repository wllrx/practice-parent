package cn.wllsrx.zoe.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zoe
 **/
@Data
@ApiModel("影院返回对象")
public class CinemaVO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "影院名称")
    private String cinemaName;

    @ApiModelProperty(value = "影院电话")
    private String cinemaPhone;

    @ApiModelProperty(value = "品牌编号")
    private Integer brandId;

    @ApiModelProperty(value = "地域编号")
    private Integer areaId;

    @ApiModelProperty(value = "包含的影厅类型,以#作为分割")
    private String hallIds;

    @ApiModelProperty(value = "影院图片地址")
    private String imgAddress;

    @ApiModelProperty(value = "影院地址")
    private String cinemaAddress;

    @ApiModelProperty(value = "最低票价")
    private BigDecimal minimumPrice;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
