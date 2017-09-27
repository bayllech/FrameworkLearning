package cn.bayllech.controller;

import cn.bayllech.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-27 15:45
 */
@Controller
@RequestMapping
public class LoginController {

   @RequestMapping("")
    public ModelAndView loginJsp() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(User user) {
        ModelMap modelMap = new ModelMap();
        //shiro方式登录
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(user.getUsername(),user.getPassword()));
            modelMap.addAttribute("code", "000000");
        } catch (AuthenticationException e) {
            modelMap.addAttribute("msg", e.getMessage());
        }

        return new ModelAndView("jsonView", modelMap);
    }

}
