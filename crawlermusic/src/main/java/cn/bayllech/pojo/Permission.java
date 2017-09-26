package cn.bayllech.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-26 13:17
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = -2243065361727365330L;

    private Integer id;
    private String perssionName;
    private String perssionCode;
    private Integer status;
}
