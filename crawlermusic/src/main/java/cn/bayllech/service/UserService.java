package cn.bayllech.service;

import cn.bayllech.pojo.User;

import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-30 16:42
 */
public interface UserService {
    List<User> findByPage(String username, String start, String pageSize);

    int findTotal(String username);
}
