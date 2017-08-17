package cn.bayllech.project.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author bei.qi
 * @Date 2017-08-17 14:03
 */
@Data
public class DUser implements Serializable{

    private String userId;
    private String userName;
    private Date createTime;
}
