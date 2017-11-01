package cn.bayllech.service;

import cn.bayllech.pojo.TUserInfo;

import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-01 10:30
 */
public interface UserInfoService {
    List<TUserInfo> selectAll();
}
