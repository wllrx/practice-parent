package cn.wllsrx.zoe.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zoe
 **/
@Data
@ApiModel("演员返回对象")
public class ActorVO {

    @ApiModelProperty("演员id")
    private Integer actorId;

    @ApiModelProperty("演员名称")
    private String actorName;

    @ApiModelProperty("角色名称")
    private String roleName;
}
