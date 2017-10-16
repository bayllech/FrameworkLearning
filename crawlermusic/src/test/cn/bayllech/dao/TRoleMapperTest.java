package cn.bayllech.dao;

import cn.bayllech.pojo.TRole;
import cn.bayllech.pojo.TRoleExample;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-10-16 9:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TRoleMapperTest {

    @Resource
    private TRoleMapper tRoleMapper;

    private TRole tRole = new TRole();
    private TRoleExample tRoleExample = new TRoleExample();

    @Test
    public void countByExample() throws Exception {
        Long total = tRoleMapper.countByExample(tRoleExample);
        Assert.assertEquals(total.intValue(),2);
    }

    @Test
    public void deleteByExample() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        tRole.setRoleName("测试");
        tRole.setRoleCode("test");
        tRole.setStatus(1);
        tRoleMapper.insertSelective(tRole);
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByExample() throws Exception {
/*        tRoleExample.createCriteria()
                .andIdEqualTo(1);*/
        tRoleExample.setOffset(0);
        tRoleExample.setLimit(10);
        List<TRole> list = tRoleMapper.selectByExample(tRoleExample);
        Assert.assertEquals(list.size(), 2);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByExampleSelective() throws Exception {
    }

    @Test
    public void updateByExample() throws Exception {
        tRole = tRoleMapper.selectByPrimaryKey(4);
        tRole.setRoleName("测试2");
        tRoleMapper.updateByPrimaryKeySelective(tRole);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}