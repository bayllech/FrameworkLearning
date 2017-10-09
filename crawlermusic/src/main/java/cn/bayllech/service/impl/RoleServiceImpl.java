package cn.bayllech.service.impl;

import cn.bayllech.dao.RoleMapper;
import cn.bayllech.dao.UserMapper;
import cn.bayllech.pojo.Role;
import cn.bayllech.pojo.User;
import cn.bayllech.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-30 16:43
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findByPage(String roleName, Integer start, Integer pageSize) {
        Role role = new Role();
        role.setRoleName(roleName);
        return roleMapper.selectBySelection(role,start,pageSize);
    }

    @Override
    public int findTotal(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        return roleMapper.findTotal(role);
    }
}
