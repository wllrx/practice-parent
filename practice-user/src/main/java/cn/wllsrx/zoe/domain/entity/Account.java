package cn.wllsrx.zoe.domain.entity;

import cn.wllsrx.zoe.config.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author zoe
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("account")
@Document(indexName = "practice" , type = "account")
public class Account extends BaseEntity<Integer> {

    /**
     * 用户账号
     *
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    @TableField("user_name")
    private String userName;

    /**
     * 用户密码
     */
    @Field(type = FieldType.Keyword,index = false)
    @TableField("user_pwd")
    private String userPwd;

    /**
     * 用户手机号
     */
    @Field(type = FieldType.Keyword,index = false)
    @TableField("user_phone")
    private String userPhone;
}
