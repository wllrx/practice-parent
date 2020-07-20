package cn.wllsrx.zoe.staging;

import cn.gjing.tools.common.util.ParamUtils;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author zoe
 **/
public enum OrderStatus implements IEnum<Integer> {

    /**
     * 订单状态
     */
    UNPAID(1,"待支付"),
    PAID(2,"已支付"),
    CLOSE(3,"已关闭");

    private int type;
    private String desc;

    OrderStatus(Integer type, String desc) {
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

    public static OrderStatus of(String desc) {
        for (OrderStatus orderStatus: OrderStatus.values()) {
            if (ParamUtils.equals(orderStatus.desc, desc)) {
                return orderStatus;
            }
        }
        return null;
    }
}
