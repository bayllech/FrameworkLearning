package cn.bayllech.project.mapper;

import cn.bayllech.project.pojo.TUserInfo;

import java.util.List;

/**
 * @Author bei.qi
 * @Date 2017-08-11 17:43
 */
public interface TUserInfoMapper {

    List<TUserInfo> findAllUser();
}
