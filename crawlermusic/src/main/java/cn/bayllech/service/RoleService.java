package cn.bayllech.service;

import cn.bayllech.pojo.Role;
import cn.bayllech.pojo.User;

import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-30 16:42
 */
public interface RoleService {
    List<Role> findByPage(String roleName, Integer start, Integer pageSize);

    int findTotal(String roleName);
}
