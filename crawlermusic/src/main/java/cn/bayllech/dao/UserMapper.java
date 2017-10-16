package cn.bayllech.dao;

import cn.bayllech.pojo.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-27 15:13
 */
public interface UserMapper{

    User findByUsername(String username);

    Set<String> findRoles(String username);

    List<User> selectBySelection(@Param("user") User user, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    int findTotal(@Param("user") User user);

    Set<String> findPermissions(String username);
}
