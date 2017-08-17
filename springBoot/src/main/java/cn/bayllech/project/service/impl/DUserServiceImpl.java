package cn.bayllech.project.service.impl;

import cn.bayllech.project.mapper.DUserMapper;
import cn.bayllech.project.pojo.DUser;
import cn.bayllech.project.service.DUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author bei.qi
 * @Date 2017-08-17 15:44
 */
@Service
public class DUserServiceImpl implements DUserService {
    @Autowired
    private DUserMapper dUserMapper;

    @Override
    public List<DUser> findAllUser() {
        return dUserMapper.findAllUser();
    }
}
