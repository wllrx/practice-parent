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
@TableName("source_dict")
public class SourceDict extends BaseEntity<Integer> {

    /**
     * 显示名称
     */
    @TableField("show_name")
    private String showName;
}
