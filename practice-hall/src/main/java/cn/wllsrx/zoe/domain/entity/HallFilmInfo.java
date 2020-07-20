package cn.wllsrx.zoe.domain.entity;

import cn.wllsrx.zoe.config.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author zoe
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("hall_film_info")
public class HallFilmInfo extends BaseEntity<Integer> {

    /**
     * 电影编号
     */
    @TableField("film_id")
    private Integer filmId;

    /**
     * 电影名称
     */
    @TableField("film_name")
    private String filmName;

    /**
     * 电影时长
     */
    @TableField("film_length")
    private String filmLength;

    /**
     * 电影类型
     */
    @TableField("film_cats")
    private String filmCats;

    /**
     * 电影语言
     */
    @TableField("film_language")
    private String filmLanguage;

    /**
     * 演员列表
     */
    @TableField("actors")
    private String actors;

    /**
     * 图片地址
     */
    @TableField("img_address")
    private String imgAddress;
}
