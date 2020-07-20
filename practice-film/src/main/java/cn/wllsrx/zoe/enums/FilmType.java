package cn.wllsrx.zoe.enums;

import cn.gjing.tools.common.util.ParamUtils;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author zoe
 **/
public enum FilmType implements IEnum<Integer> {

    /**
     * 片源类型
     */

    TWO(1,"2D"),
    THREE(2,"3D"),
    MAX(3,"3DIMAX"),
    NO(4,"无");

    private int type;
    private String desc;

    FilmType(Integer type, String desc) {
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

    public static FilmType of(String desc) {
        for (FilmType filmType : FilmType.values()) {
            if (ParamUtils.equals(filmType.desc, desc)) {
                return filmType;
            }
        }
        return null;
    }
}
