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
@TableName("actor")
public class Actor extends BaseEntity<Integer> {

    /**
     * 演员名称
     */
    @TableField("actor_name")
    private String actorName;

    /**
     * 演员图片位置
     */
    @TableField("actor_img")
    private String actorImg;
}
