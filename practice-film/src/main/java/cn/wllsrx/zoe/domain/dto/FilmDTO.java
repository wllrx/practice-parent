package cn.wllsrx.zoe.domain.dto;

import cn.gjing.tools.common.valid.NotEmpty;
import cn.wllsrx.zoe.enums.FilmStatus;
import cn.wllsrx.zoe.enums.FilmType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author zoe
 **/
@Data
@ApiModel("影片新增传输对象")
public class FilmDTO {

    @NotEmpty(message = "电影状态不能为空!")
    @ApiModelProperty(value = "电影状态 1:正在热映 2:即将上映 3:经典影片", required = true)
    private FilmStatus filmstatus;

    @ApiModelProperty(value = "电影名称", required = true)
    private String filmName;

    @ApiModelProperty(value = "电影英文名称", required = true)
    private String filmEnName;

    @ApiModelProperty(value = "电影宣传图地址", required = true)
    private String imgAddress;

    @ApiModelProperty(value = "电影评分", required = true)
    private String filmScore;

    @ApiModelProperty(value = "评分人数", required = true)
    private Integer filmScoreNum;

    @ApiModelProperty(value = "电影预售票房", required = true)
    private Integer filmPreSaleNum;

    @ApiModelProperty(value = "电影实时票房", required = true)
    private Integer filmBoxOffice;

    @ApiModelProperty(value = "电影来源编号", required = true)
    private Integer filmSourceId;

    @ApiModelProperty(value = "电影分类编号", required = true)
    private String filmCatIds;

    @ApiModelProperty(value = "电影地区编号", required = true)
    private Integer filmAreaId;

    @ApiModelProperty(value = "影片年代编号", required = true)
    private Integer filmDateId;

    @ApiModelProperty(value = "上映时间", required = true)
    private Date filmTime;

    @ApiModelProperty(value = "导演编号", required = true)
    private Integer directorId;

    @ApiModelProperty(value = "演员编号", required = true)
    private Integer actorId;

    @ApiModelProperty(value = "角色名称", required = true)
    private String roleName;

    @ApiModelProperty(value = "电影时长", required = true)
    private Integer filmLength;

    @ApiModelProperty(value = "电影介绍", required = true)
    private String biography;

    @ApiModelProperty(value = "电影经典图片地址", required = true)
    private String filmImages;

    @ApiModelProperty(value = "片源类型", required = true)
    private FilmType filmType;
}
