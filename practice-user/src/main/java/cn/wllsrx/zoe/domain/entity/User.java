package cn.wllsrx.zoe.domain.entity;

import cn.wllsrx.zoe.config.BaseEntity;
import cn.wllsrx.zoe.enums.Gender;
import cn.wllsrx.zoe.enums.LifeState;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @author zoe
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user")
public class User extends BaseEntity<Integer> {

    /**
     * 用户账号
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户密码
     */
    @TableField("user_pwd")
    private String userPwd;

    /**
     * 用户手机号
     */
    @TableField("user_phone")
    private String userPhone;

    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 用户性别
     */
    @TableField("user_sex")
    private Gender userSex;

    /**
     * 出生日期
     */
    @TableField("birthday")
    private Date birthday;

    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 用户住址
     */
    @TableField("address")
    private String address;

    /**
     * 头像URL
     */
    @TableField("head_url")
    private String headUrl;

    /**
     * 个人介绍
     */
    @TableField("biography")
    private String biography;

    /**
     * 生活状态 1-单身，2-热恋中，3-已婚，4-为人父母
     */
    @TableField("life_state")
    private LifeState lifeState;

}
