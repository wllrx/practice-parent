package cn.wllsrx.zoe.staging;

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
@TableName("banner")
public class Banner extends BaseEntity<Integer> {

    /**
     * banner图存放路径
     */
    @TableField("banner_address")
    private String bannerAddress;

    /**
     * banner点击跳转url
     */
    @TableField("banner_url")
    private String bannerUrl;

    /**
     * 是否弃用 0-失效,1-失效
     */
    @TableField("is_valid")
    private Integer isValid;
}
