package cn.wllsrx.zoe.staging;

import cn.wllsrx.zoe.config.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author zoe
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("order")
public class Order extends BaseEntity<Integer> {

    /**
     * 影院编号
     */
    @TableField("cinema_id")
    private Integer cinemaId;

    /**
     * 放映场次编号
     */
    @TableField("field_id")
    private Integer fieldId;

    /**
     * 电影编号
     */
    @TableField("film_id")
    private Integer filmId;

    /**
     * 已售座位编号
     */
    @TableField("seats_ids")
    private String seatsIds;

    /**
     * 已售座位名称
     */
    @TableField("seats_name")
    private String seatsName;

    /**
     * 影片售价
     */
    @TableField("film_price")
    private BigDecimal filmPrice;

    /**
     * 订单总金额
     */
    @TableField("order_price")
    private BigDecimal orderPrice;

    /**
     * 下单时间
     */
    @TableField("order_time")
    private String orderTime;

    /**
     * 下单人
     */
    @TableField("order_user")
    private String orderUser;

    /**
     * 订单状态
     */
    @TableField("order_status")
    private OrderStatus orderStatus;


}
