package cn.wllsrx.zoe.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * @author zoe
 **/
public class XSrteam {
    public static void main(String[] args) {

        CartGoods cartGoods = new CartGoods("iPhone", "3C", "5000.00", "2");
        //XStream xStream = new XStream();
        XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));//解决下划线问题
        xStream.autodetectAnnotations(true); //自动检测注解
        xStream.addPermission(AnyTypePermission.ANY);
        xStream.processAnnotations(CartGoods.class); //应用Bean类的注解
        String toXML = xStream.toXML(cartGoods);
        // 序列化
        System.out.println("序列化: " + toXML);
        // 反序列化
        Object fromXML = xStream.fromXML(toXML);
        System.out.println("反序列化: " + fromXML);
    }
}
