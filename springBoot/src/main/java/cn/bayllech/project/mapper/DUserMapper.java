package cn.bayllech.project.mapper;

import cn.bayllech.project.pojo.DUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author bei.qi
 * @Date 2017-08-17 15:44
 */
@Mapper
public interface DUserMapper {
    List<DUser> findAllUser();
}
