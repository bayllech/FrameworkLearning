package cn.bayllech.dao;

import cn.bayllech.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-10-13 17:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    private User user = new User();
    @Test
    public void findByUsername() throws Exception {
        user.setUsername("tom");
        userMapper.findTotal(user);
    }

    @Test
    public void findRoles() throws Exception {
    }

    @Test
    public void selectBySelection() throws Exception {
    }

    @Test
    public void findTotal() throws Exception {
    }

    @Test
    public void findPermissions() throws Exception {
    }

}