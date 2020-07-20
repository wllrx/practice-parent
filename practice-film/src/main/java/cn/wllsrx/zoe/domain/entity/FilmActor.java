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
@TableName("film_actor")
public class FilmActor extends BaseEntity<Integer> {

    /**
     * 影片编号,对应film
     */
    @TableField("film_id")
    private Integer filmId;

    /**
     * 演员编号,对应actor
     */
    @TableField("actor_id")
    private Integer actorId;

    /**
     * 角色名称
     */
    @TableField("role_name")
    private String roleName;
}
