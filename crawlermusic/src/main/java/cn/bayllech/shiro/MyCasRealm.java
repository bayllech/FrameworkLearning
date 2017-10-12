package cn.bayllech.shiro;

import cn.bayllech.dao.UserMapper;
import cn.bayllech.pojo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
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

    /**
     * 登录认证
     * @param token 登录用户名和密码token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       /* UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String userName = usernamePasswordToken.getUsername();*/

        String username = token.getPrincipal().toString() ;
        User user = userMapper.findByUsername(username);
        if(user != null) {
            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        }
        return null;

       /* if (user != null){
            //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数随便放一个就行了。
           return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
        }else{
            return  null ;
        }*/
    }
}
