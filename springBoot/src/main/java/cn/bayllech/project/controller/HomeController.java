package cn.bayllech.project.controller;

import cn.bayllech.project.pojo.DUser;
import cn.bayllech.project.pojo.TUserInfo;
import cn.bayllech.project.service.DUserService;
import cn.bayllech.project.service.TUserInfoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author bei.qi
 * @Date 2017-08-10 15:10
 */
@Controller
public class HomeController {

    @Autowired
    private TUserInfoService tuserInfoService;
    @Autowired
    private DUserService dUserService;

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

    @RequestMapping(value = "/user")
    @ResponseBody
    public List<TUserInfo> userInfo() {
        List<TUserInfo> userList = tuserInfoService.findAllUser();
        return userList;
    }

    @RequestMapping(value = "/userList")
    @ResponseBody
    public ModelMap userInfoList() {
        ModelMap model = new ModelMap();
        List<TUserInfo> userList = tuserInfoService.findAllUser();
        model.addAttribute("userList", userList);
        return model;
    }

    @RequestMapping("/duser")
    @ResponseBody
    public ModelMap dubboUser(HttpServletRequest request) {
        String ip1 = request.getHeader("x-forwarded-for");
        ip1 = request.getHeader("Proxy-Client-IP");
        ip1 = request.getHeader("WL-Proxy-Client-IP");
        ip1 = request.getRemoteAddr();
        ip1 = request.getLocalAddr();
        System.out.println(ip1);
        ModelMap modelMap = new ModelMap();
        List<DUser> userList = dUserService.findAllUser();
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//        return gson.toJson(userList);
        modelMap.addAttribute("userList", userList);
        return modelMap;
    }

}
