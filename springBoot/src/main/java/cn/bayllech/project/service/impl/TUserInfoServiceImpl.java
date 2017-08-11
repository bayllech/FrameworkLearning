package cn.bayllech.project.service.impl;

import cn.bayllech.project.mapper.TUserInfoMapper;
import cn.bayllech.project.pojo.TUserInfo;
import cn.bayllech.project.service.TUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author bei.qi
 * @Date 2017-08-11 17:48
 */
@Service("userInfoService")
public class TUserInfoServiceImpl implements TUserInfoService{

    @Autowired
    private TUserInfoMapper tUserInfoMapper;

    @Override
    public List<TUserInfo> findAllUser() {
        return tUserInfoMapper.findAllUser();
    }
}
