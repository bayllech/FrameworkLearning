package cn.bayllech.project.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author bei.qi
 * @Date 2017-08-11 17:38
 */
@Data
public class TUserInfo implements Serializable {
    private static final long serialVersionUID = 3136606674585290666L;

    private String userId;

    private String userName;

    private String userKey;

    private String sex;

    private String userPhone;

    private String headUrl;

    private String userEmail;

    private String status;

    private Date createTime;

    private Date updateTime;

    private Date registerTime;

    private String sourceUserId;
}
