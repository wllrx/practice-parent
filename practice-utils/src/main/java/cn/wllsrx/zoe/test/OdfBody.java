package cn.wllsrx.zoe.test;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Data;

/**
 * @author zoe
 **/
@Data
@XStreamAlias("OdfBody")
public class OdfBody {

    @XStreamAsAttribute
    @XStreamAlias("Source")
    private String Source;

    @XStreamAsAttribute
    @XStreamAlias("LogicalDate")
    private String LogicalDate;

    @XStreamAsAttribute
    @XStreamAlias("Time")
    private String Time ;

    @XStreamAsAttribute
    @XStreamAlias("Date")
    private String Date ;

    @XStreamAsAttribute
    @XStreamAlias("Version")
    private String Version ;

    @XStreamAsAttribute
    @XStreamAlias("DocumentType")
    private String DocumentType ;

    @XStreamAsAttribute
    @XStreamAlias("DocumentCode")
    private String DocumentCode ;

    @XStreamAsAttribute
    @XStreamAlias("CompetitionCode")
    private String CompetitionCode ;

    @XStreamAlias("Competition")
    private String Competition;

    @XStreamAsAttribute
    @XStreamAlias("Code")
    private String Code;

    @XStreamAsAttribute
    @XStreamAlias("SportDes")
    private String SportDes;

    private String Weather;


    private String Condition;

    @XStreamAsAttribute
    @XStreamAlias("Type")
    private String Type;

    @XStreamAsAttribute
    @XStreamAlias("Dimension")
    private String Dimension;












}
