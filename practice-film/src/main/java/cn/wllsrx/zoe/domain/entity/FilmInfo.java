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
@TableName("film_info")
public class FilmInfo extends BaseEntity<Integer> {

    /**
     * 影片编号
     */
    @TableField("film_id")
    private String filmId;

    /**
     * 影片英文名称
     */
    @TableField("film_en_name")
    private String filmEnName;

    /**
     * 影片评分
     */
    @TableField("film_score")
    private String filmScore;

    /**
     * 评分人数,以万为单位
     */
    @TableField("film_score_num")
    private Integer filmScoreNum;

    /**
     * 播放时长，以分钟为单位，不足取整
     */
    @TableField("film_length")
    private Integer filmLength;

    /**
     * 影片介绍
     */
    @TableField("biography")
    private String biography;

    /**
     * 导演编号
     */
    @TableField("director_id")
    private Integer directorId;

    /**
     * 演员编号,对应actor
     */
    @TableField("actor_ids")
    private String actorIds;

    /**
     * 影片图片集地址,多个图片以逗号分隔
     */
    @TableField("film_images")
    private String filmImages;
}
