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
@TableName("hall_dict")
public class HallDict extends BaseEntity<Integer> {

    /**
     * 显示名称
     */
    @TableField("show_name")
    private String showName;

    /**
     * 座位文件存放地址
     */
    @TableField("seat_address")
    private String seatAddress;
}
