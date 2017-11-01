package cn.bayllech.service.impl;

import cn.bayllech.dao.UserInfoMapper;
import cn.bayllech.pojo.TUserInfo;
import cn.bayllech.pojo.TUserInfoExample;
import cn.bayllech.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-01 10:30
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    
    @Autowired
    private UserInfoMapper userInfoMapper;
    
    @Override
    public List<TUserInfo> selectAll() {
        
        return userInfoMapper.selectByExample(new TUserInfoExample());
    }
}
