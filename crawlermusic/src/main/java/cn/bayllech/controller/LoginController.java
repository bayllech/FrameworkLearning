package cn.bayllech.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-26 15:47
 */
@Controller
@RequestMapping
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    /**
     * 使用shiro方法登录
     * @return
     */
    @PostMapping("/login")
    public ModelMap login(String username, String password, RedirectAttributes redirectAttributes) {
        ModelMap model = new ModelMap();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username,password));
            model.addAttribute("code", "000000");
        } catch (AuthenticationException e) {
            model.addAttribute("msg", "账号或密码错误");
        }

        return model;
    }
}
