package cn.wllsrx.zoe.domain.entity;

import cn.wllsrx.zoe.config.BaseEntity;
import cn.wllsrx.zoe.enums.FilmStatus;
import cn.wllsrx.zoe.enums.FilmType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @author zoe
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("film")
public class Film extends BaseEntity<Integer> {

    /**
     * 影片名称
     */
    @TableField("film_name")
    private String filmName;

    /**
     * 片源类型: 0-2D,1-3D,2-3D MAX,4-无
     */
    @TableField("film_type")
    private FilmType filmType;

    /**
     * 影片主图地址
     */
    @TableField("img_address")
    private String imgAddress;

    /**
     * 影片评分
     */
    @TableField("film_score")
    private String filmScore;

    /**
     * 影片预售数量
     */
    @TableField("film_preSaleNum")
    private Integer filmPreSaleNum;

    /**
     * 影片票房：每日更新，以万为单位
     */
    @TableField("film_box_office")
    private Integer filmBoxOffice;

    /**
     * 影片片源，参照片源字典 sourceDict表
     */
    @TableField("film_source_id")
    private Integer filmSourceId;

    /**
     * 影片分类，参照分类表,多个分类以#分割
     */
    @TableField("film_cat_ids")
    private String filmCatIds;

    /**
     * 影片区域，参照区域表
     */
    @TableField("film_area_id")
    private Integer filmAreaId;

    /**
     * 影片上映年代，参照年代表
     */
    @TableField("film_date_id")
    private Integer filmDateId;

    /**
     * 影片上映时间
     */
    @TableField("film_time")
    private Date filmTime;

    /**
     * 影片状态,1-正在热映，2-即将上映，3-经典影片
     */
    @TableField("film_status")
    private FilmStatus filmStatus;

}
