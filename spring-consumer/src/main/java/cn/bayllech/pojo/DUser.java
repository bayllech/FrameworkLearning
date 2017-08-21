package cn.bayllech.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author bei.qi
 * @Date 2017-08-21 9:37
 */
@Data
public class DUser implements Serializable {
    private static final long serialVersionUID = -5709106172754531766L;
    private String userId;
    private String userName;
    private Date createTime;
}
