package cn.wllsrx.zoe.domain.entity;

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
@TableName("cinema")
public class Cinema extends BaseEntity<Integer> {

    /**
     * 影院名称
     */
    @TableField("cinema_name")
    private String cinemaName;

    /**
     * 影院电话
     */
    @TableField("cinema_phone")
    private String cinemaPhone;

    /**
     * 品牌编号
     */
    @TableField("brand_id")
    private Integer brandId;

    /**
     * 地域编号
     */
    @TableField("area_id")
    private Integer areaId;

    /**
     * 包含的影厅类型,以#作为分割
     */
    @TableField("hall_ids")
    private String hallIds;

    /**
     * 影院图片地址
     */
    @TableField("img_address")
    private String imgAddress;

    /**
     * 影院地址
     */
    @TableField("cinema_address")
    private String cinemaAddress;

    /**
     * 最低票价
     */
    @TableField("minimum_price")
    private BigDecimal minimumPrice;


}
