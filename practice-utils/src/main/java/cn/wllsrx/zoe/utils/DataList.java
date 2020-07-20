package cn.wllsrx.zoe.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.security.AnyTypePermission;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@XStreamAlias("Data")
public class DataList {
	@XStreamImplicit(itemFieldName = "Head")
	private List<TestXmlClass> list;
}

class Test{
	public static void main(String[] args) throws IOException {
		//创建xstream对象
		XStream xStream = new XStream();
		//处理给定类型注释配置stream,调用此方法自动关闭注释自动检测模式
		xStream.processAnnotations(DataList.class);
		//消除所有限制,解决安全问题异常security.ForbiddenClassException
		xStream.addPermission(AnyTypePermission.ANY);
		// 读取XML文件
		Resource resource = new ClassPathResource("citylist.xml");
		DataList dataList= (DataList)xStream.fromXML(resource.getFile());
		System.out.println(dataList);
	}
}
@SuppressWarnings("unchecked")
class Util{
	public static<T> T xmlToEntity(Class<T> data, File xml) {
		//创建xstream对象
		XStream xStream = new XStream();
		//处理给定类型注释配置stream,调用此方法自动关闭注释自动检测模式
		xStream.processAnnotations(data);
		//消除所有限制,解决安全问题异常security.ForbiddenClassException
		xStream.addPermission(AnyTypePermission.ANY);
		return (T) xStream.fromXML(xml);
	}

	public static String entityToXml(Object object){
		XStream xStream = new XStream();
		//开启注释自动检测模式
		xStream.autodetectAnnotations(true);
		return xStream.toXML(object);
	}

	public static void main(String[] args) throws IOException {
		//xml转bean
		Resource resource = new ClassPathResource("citylist.xml");
		DataList dataList = xmlToEntity(DataList.class, resource.getFile());
		List<TestXmlClass> list = dataList.getList();
		for (TestXmlClass testXmlClass : list) {
			System.out.println(testXmlClass.getOcc18());
		}
		System.out.println(list);

		//bean转xml
		List<TestXmlClass> lists = new ArrayList<>();
		lists.add(TestXmlClass.builder().occ01("1").occdate("2020-1-2").occ02("大多测试定").occ18("大多打iou").occacti("大多大多甲方甲方收到").build());
		lists.add(TestXmlClass.builder().occ01("2").occdate("2020-1-3").occ02("大多规范化").occ18("大多打机构行家").occacti("大多大多").build());
		lists.add(TestXmlClass.builder().occ01("3").occdate("2020-1-4").occ02("大多和风格和").occ18("大多打集合根据").occacti("大多大多飞洒发").build());
		String s = entityToXml(lists);
		System.out.println(s);
	}
}
