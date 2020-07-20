package cn.wllsrx.zoe.enums;

import cn.gjing.tools.common.util.ParamUtils;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author zoe
 **/
public enum Gender implements IEnum<Integer> {
    /**
     * 性别
     */
    MAN(1,"男"),
    WOMAN(2,"女"),
    CROSS(3,"混合");
    private int type;
    private String desc;

    Gender(Integer type, String desc) {
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

    public Gender of() {
        return this;
    }

    public static Gender of(String desc) {
        for (Gender gender : Gender.values()) {
            if (ParamUtils.equals(gender.desc, desc)) {
                return gender;
            }
        }
        return null;
    }
}
