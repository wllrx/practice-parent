package cn.wllsrx.zoe.utils;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
//访问类型，通过字段
@XmlAccessorType(XmlAccessType.FIELD)
@Builder
@XStreamAlias("Head")
public class TestXmlClass {
	private String occ01;
	private String occ02;
	private String occ18;
	private String occacti;
	private String occdate;
}
