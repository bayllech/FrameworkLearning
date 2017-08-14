package cn.bayllech.project.mapper;

import cn.bayllech.project.pojo.TUserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author bei.qi
 * @Date 2017-08-11 17:43
 */
@Mapper
public interface TUserInfoMapper {

    List<TUserInfo> findAllUser();
}
