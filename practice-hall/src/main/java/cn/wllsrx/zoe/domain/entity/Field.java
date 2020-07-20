package cn.wllsrx.zoe.domain.entity;

import cn.wllsrx.zoe.config.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zoe
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("field")
public class Field extends BaseEntity<Integer> {

    /**
     * 影院编号
     */
    @TableField("cinema_id")
    private Integer cinemaId;

    /**
     * 电影编号
     */
    @TableField("film_id")
    private Integer filmId;

    /**
     * 开始时间
     */
    @TableField("begin_time")
    private Date beginTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private Date endTime;

    /**
     * 放映厅类型编号
     */
    @TableField("hall_id")
    private Integer hallId;

    /**
     * 放映厅名称
     */
    @TableField("hall_name")
    private String hallName;

    /**
     * 票价
     */
    @TableField("price")
    private BigDecimal price;


}
