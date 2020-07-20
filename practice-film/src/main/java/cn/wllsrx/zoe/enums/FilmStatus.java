package cn.wllsrx.zoe.enums;

import cn.gjing.tools.common.util.ParamUtils;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author zoe
 **/
public enum  FilmStatus implements IEnum<Integer> {

    /**
     * 影片状态
     */

    HOT(1,"正在热映"),
    COMING(2,"即将上映"),
    CLASSIC(3,"经典影片");

    private int type;
    private String desc;

    FilmStatus(Integer type, String desc) {
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

    public static FilmStatus of(String desc) {
        for (FilmStatus filmStatus : FilmStatus.values()) {
            if (ParamUtils.equals(filmStatus.desc, desc)) {
                return filmStatus;
            }
        }
        return null;
    }
}
