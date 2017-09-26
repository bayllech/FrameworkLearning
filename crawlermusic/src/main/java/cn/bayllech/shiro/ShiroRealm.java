package cn.bayllech.shiro;

import cn.bayllech.dao.UserMapper;
import cn.bayllech.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-26 16:14
 */
public class ShiroRealm {
    @Component
    public class ShiroDbRealm extends AuthorizingRealm {

        @Autowired
        private UserMapper userMapper;

        /**
         * 权限认证
         * @param principalCollection
         * @return
         */
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

            return null;
        }

        /**
         * 登录认证
         *
         * @param authenticationToken
         * @return
         * @throws AuthenticationException
         */
        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
            UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
            String userName = usernamePasswordToken.getUsername();
            User user = userMapper.findByUserName(userName);
            if (user != null) {
                return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
            }
            return null;
        }
    }
}
