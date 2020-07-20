package cn.wllsrx.zoe.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zoe
 **/
@Data
@ApiModel("影院传输对象")
public class CinemaDTO {

    @ApiModelProperty(value = "影院名称", required = true)
    private String cinemaName;

    @ApiModelProperty(value = "影院电话", required = true)
    private String cinemaPhone;

    @ApiModelProperty(value = "品牌编号", required = true)
    private Integer brandId;

    @ApiModelProperty(value = "地域编号", required = true)
    private Integer areaId;

    @ApiModelProperty(value = "包含的影厅类型,以#作为分割", required = true)
    private String hallIds;

    @ApiModelProperty(value = "影院图片地址", required = true)
    private String imgAddress;

    @ApiModelProperty(value = "影院地址", required = true)
    private String cinemaAddress;

    @ApiModelProperty(value = "最低票价", required = true)
    private BigDecimal minimumPrice;
}
