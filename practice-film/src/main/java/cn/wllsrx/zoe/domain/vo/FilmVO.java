package cn.wllsrx.zoe.domain.vo;

import cn.wllsrx.zoe.enums.FilmStatus;
import cn.wllsrx.zoe.enums.FilmType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author zoe
 **/
@Data
public class FilmVO {

    @ApiModelProperty("影片名称")
    private String filmName;

    @ApiModelProperty("片源类型")
    private FilmType filmType;

    @ApiModelProperty("影片主图地址")
    private String imgAddress;

    @ApiModelProperty("影片评分")
    private String filmScore;

    @ApiModelProperty("影片预售数量")
    private Integer filmPreSaleNum;

    @ApiModelProperty("影片票房")
    private Integer filmBoxOffice;

    @ApiModelProperty("影片片源")
    private Integer filmSourceId;

    @ApiModelProperty("影片分类")
    private String filmCatIds;

    @ApiModelProperty("影片区域")
    private Integer filmAreaId;

    @ApiModelProperty("影片上映年代")
    private Integer filmDateId;

    @ApiModelProperty("影片上映时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date filmTime;

    @ApiModelProperty("影片状态")
    private FilmStatus filmStatus;

    @ApiModelProperty("影片英文名称")
    private String filmEnName;

    @ApiModelProperty("评分人数")
    private Integer filmScoreNum;

    @ApiModelProperty("播放时长")
    private Integer filmLength;

    @ApiModelProperty("影片介绍")
    private String biography;

    @ApiModelProperty("导演编号")
    private Integer directorId;

    @ApiModelProperty("演员编号")
    private String actorIds;

    @ApiModelProperty("影片图片集地址,多个图片以逗号分隔")
    private String filmImages;
}
