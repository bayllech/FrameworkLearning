package cn.bayllech.project.service.impl;

import cn.bayllech.project.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-12-18 10:13
 */
public class UserInfoServiceImplTest {
    
    @Autowired
    UserInfoServiceImpl userInfoService;
    
    @Test
    public void saveUser() {
        User user = new User(1L,"tom","123456");
        userInfoService.saveUser(user);
    }
    
    @Test
    public void findUserByUsername() {
    }
    
    @Test
    public void updateUser() {
    }
    
    @Test
    public void deleteUserById() {
    }
}