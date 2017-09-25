package cn.bayllech.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-19 17:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 2450229892601640364L;

    private Integer id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
}
