package cn.wllsrx.zoe.enums;

import cn.gjing.tools.common.util.ParamUtils;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author zoe
 **/
public enum LifeState implements IEnum<Integer> {

    /**
     * 生活状态
     */
    SINGLE(1,"单身"),
    IN_LOVE(2,"热恋"),
    MARRIED(3,"已婚"),
    PARENTING(4,"为人父母");

    private final int type;
    private final String desc;

    LifeState(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.type;
    }

    @JsonValue
    public String getDesc() {
        return this.desc;
    }

    public static LifeState of(String desc) {
        for (LifeState lifeState: LifeState.values()) {
            if (ParamUtils.equals(lifeState.desc, desc)) {
                return lifeState;
            }
        }
        return null;
    }
}
