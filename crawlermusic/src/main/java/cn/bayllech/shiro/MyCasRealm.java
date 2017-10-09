package cn.bayllech.shiro;

import cn.bayllech.dao.UserMapper;
import cn.bayllech.pojo.User;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-10-09 17:57
 */
public class MyCasRealm extends CasRealm {
    @Autowired
    private UserMapper userMapper;
    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User)principalCollection.getPrimaryPrincipal();
        String username = user.getUsername();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userMapper.findRoles(username));
        authorizationInfo.setStringPermissions(userMapper.findPermissions(username));

        return authorizationInfo;
    }

}
