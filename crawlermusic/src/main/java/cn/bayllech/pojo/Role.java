package cn.bayllech.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-26 13:16
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -6396775780497257415L;

    private Integer id;
    private String roleName;
    private String roleCode;
    private Integer status;

    private List<Permission> permissionList;
}
