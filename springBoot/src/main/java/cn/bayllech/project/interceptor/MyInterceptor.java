package cn.bayllech.project.interceptor;

import cn.bayllech.project.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-22 15:03
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        boolean flag =true;
        User user=(User)httpServletRequest.getSession().getAttribute("user");
        if(null==user){
            //httpServletResponse.sendRedirect("/leaf/login");
            httpServletResponse.sendRedirect("/toLogin");
            flag = false;
        }else{
            flag = true;
        }
        return flag;
    }
    
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    
    }
    
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    
    }
}
