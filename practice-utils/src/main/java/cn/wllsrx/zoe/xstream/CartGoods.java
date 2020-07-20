package cn.wllsrx.zoe.xstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("cart_goods")
// 自带的转换器
 @XStreamConverter(value= ToAttributedValueConverter.class, strings={"goodsQuantity"})
// 自定义的转换器
//@XStreamConverter(CartGoodsConverter.class)
public class CartGoods {
    @XStreamAsAttribute
    @XStreamAlias("goods_name")
    private String goodsName;
    @XStreamAsAttribute
    @XStreamAlias("goods_category")
    private String goodsCategory;
    @XStreamAsAttribute
    @XStreamAlias("goods_price")
    private String goodsPrice;
    // @XStreamOmitField
    private String goodsQuantity;
}