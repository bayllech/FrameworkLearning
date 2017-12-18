package cn.bayllech.project.service.impl;

import cn.bayllech.project.mapper.UserInfoMapper;
import cn.bayllech.project.pojo.TUserInfo;
import cn.bayllech.project.pojo.TUserInfoExample;
import cn.bayllech.project.pojo.User;
import cn.bayllech.project.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-01 10:30
 */
@Component
//@Service(interfaceClass = UserInfoService.class)
public class UserInfoServiceImpl implements UserInfoService {
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    private UserInfoMapper userInfoMapper;
    
    @Override
    public List<TUserInfo> selectAll() {
        
        return userInfoMapper.selectByExample(new TUserInfoExample());
    }
    
    @Override
    public List<TUserInfo> selectByPage(Integer offset, Integer limit,String sortName,String sortOrder) {
        TUserInfoExample userInfoExample = new TUserInfoExample();
        userInfoExample.setOffset(offset);
        userInfoExample.setLimit(limit);
        userInfoExample.setOrderByClause(sortName + " " + sortOrder);
        
        return userInfoMapper.selectByExample(userInfoExample);
    }
    
    @Override
    public Long selectTotal(Integer offset, Integer limit) {
        TUserInfoExample userInfoExample = new TUserInfoExample();
    
        return userInfoMapper.countByExample(userInfoExample);
    }
    
    @Override
    public List<TUserInfo> selectByExample(TUserInfoExample userInfoExample) {
        return userInfoMapper.selectByExample(userInfoExample);
    }
    
    @Override
    public Long selectTotal(TUserInfoExample userInfoExample) {
        return userInfoMapper.countByExample(userInfoExample);
    }
    
    @Override
    public void addUser(TUserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }
    
    @Override
    public void toEdit(TUserInfo userInfo) {
        TUserInfoExample userInfoExample = new TUserInfoExample();
        userInfoExample.createCriteria().andIdEqualTo(userInfo.getId());
        userInfoMapper.updateByExample(userInfo, userInfoExample);
        
    }
    
    @Override
    public void del(Integer id) {
        userInfoMapper.deleteByPrimaryKey(id);
        
    }
    
    //mongodb 简单方法实现
    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }
    
    @Override
    public User findUserByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.findOne(query,User.class);
    }
    
    @Override
    public void updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("username", user.getUsername()).set("password", user.getPassword());
        mongoTemplate.updateFirst(query, update, User.class);
    }
    
    @Override
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }
}
