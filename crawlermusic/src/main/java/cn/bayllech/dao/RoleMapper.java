package cn.bayllech.dao;

import cn.bayllech.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-10-09 11:29
 */
public interface RoleMapper {
    Set<Role> findRoles(String username);

    List<Role> selectBySelection(@Param("role") Role role, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    int findTotal(@Param("role") Role role);
}
