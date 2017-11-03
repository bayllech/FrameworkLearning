package cn.bayllech.service;

import cn.bayllech.pojo.TUserInfo;
import cn.bayllech.pojo.TUserInfoExample;

import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-01 10:30
 */
public interface UserInfoService {
    List<TUserInfo> selectAll();
    
    List<TUserInfo> selectByPage(Integer offset, Integer limit, String sortName, String sortOrder);
    
    Long selectTotal(Integer offset, Integer limit);
    
    List<TUserInfo> selectByExample(TUserInfoExample userInfoExample);
    
    Long selectTotal(TUserInfoExample userInfoExample);
    
    void addUser(TUserInfo userInfo);
    
    void toEdit(TUserInfo userInfo);
    
    void del(Integer id);
}
