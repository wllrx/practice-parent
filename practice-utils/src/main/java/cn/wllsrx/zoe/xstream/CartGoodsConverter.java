package cn.wllsrx.zoe.xstream;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CartGoodsConverter implements Converter {
    /**
     * 将java对象转为xml时使用
     * @param source
     * @param writer
     * @param context
     */
    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        CartGoods cartGoods = (CartGoods) source;
        writer.addAttribute("order_name", cartGoods.getGoodsName());
        writer.addAttribute("order_type", cartGoods.getGoodsCategory());
        writer.addAttribute("order_price", cartGoods.getGoodsPrice());
        writer.setValue(cartGoods.getGoodsQuantity());
    }

    /**
     * 将xml转为java对象使用
     * @param reader
     * @param context
     * @return
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        // 在解析order元素时，先创建一个Order对象
        CartGoods cartGoods = new CartGoods();
        // 将order元素的name属性设置为Order对象的name属性值
        cartGoods.setGoodsName(reader.getAttribute("order_name"));
        cartGoods.setGoodsCategory(reader.getAttribute("order_type"));
        cartGoods.setGoodsPrice(reader.getAttribute("order_price"));
        // 将order元素的txt值设置为Order对象的value值
        cartGoods.setGoodsQuantity(reader.getValue());
        return cartGoods;
    }

    /**
     * 转换条件
     * @param type
     * @return
     */
    @Override
    public boolean canConvert(Class type) {
        return type.equals(CartGoods.class);
    }
}