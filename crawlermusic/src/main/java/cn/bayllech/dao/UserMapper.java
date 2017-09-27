package cn.bayllech.dao;

import cn.bayllech.pojo.User;

import java.util.Set;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-27 15:13
 */
public interface UserMapper {

    User findByUsername(String username);

    Set<String> findRoles(String username);
}
