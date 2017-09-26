package cn.bayllech.dao;

import cn.bayllech.pojo.User;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-26 16:17
 */
public interface UserMapper {

    User findByUserName(String userName);
}
