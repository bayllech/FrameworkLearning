package cn.bayllech.project.controller;

import cn.bayllech.project.pojo.TUserInfo;
import cn.bayllech.project.service.TUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author bei.qi
 * @Date 2017-08-10 15:10
 */
@Controller
public class HomeController {

    @Autowired
    private TUserInfoService userInfoService;


    @RequestMapping()
    @ResponseBody
    public String home() {
        return "Hello SpringBoot";
    }

    @RequestMapping("/jsp")
    public String vieJsp(ModelMap model) {
        /*model.addAttribute("code", "000000");
        model.addAttribute("msg", "成功");*/
        model.addAttribute("msg", "success");
        return "index";
    }

    @RequestMapping("/user")
    @ResponseBody
    public ModelMap userInfo(ModelMap model) {
        List<TUserInfo> userList = userInfoService.findAllUser();
        model.addAttribute("userList",userList);
        return model;
    }

}
