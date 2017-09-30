package cn.bayllech.controller;

import cn.bayllech.pojo.User;
import cn.bayllech.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-25 14:06
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("showUserList")
    public ModelAndView showUserList() {
        return new ModelAndView("user/userList");
    }

    @RequestMapping("getUserList")
    public ModelAndView getUserList(String username, String rows, String page) {
        ModelMap modelMap = new ModelMap();
        int total = userService.findTotal(username);
        List<User> list = userService.findByPage(username,rows,page);
        modelMap.addAttribute("total", total);
        modelMap.addAttribute("rows", list);
        return new ModelAndView("jsonView", modelMap);
    }
}
