package cn.bayllech.service.impl;

import cn.bayllech.dao.UserMapper;
import cn.bayllech.pojo.User;
import cn.bayllech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-30 16:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findByPage(String username, Integer start, Integer pageSize) {
        User user = new User();
        user.setUsername(username);
        return userMapper.selectBySelection(user,start,pageSize);
    }

    @Override
    public int findTotal(String username) {
        User user = new User();
        return userMapper.findTotal(user);
    }
}
