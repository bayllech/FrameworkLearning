package cn.bayllech.controller;

import cn.bayllech.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-01 10:29
 */
@Controller
@RequestMapping("/info")
public class UserInfoController {
    
    @Autowired
    private UserInfoService userInfoService;
    
    @RequestMapping("")
    public String infoView() {
        return "user/userInfoList";
    }
    
    
    @RequestMapping("info.json")
    public ModelAndView info(HttpServletRequest request) {
        String draw = request.getParameter("draw");
        ModelMap model = new ModelMap();
        model.addAttribute("recordsTotal", 100);
        model.addAttribute("recordsFiltered", 100);
        model.addAttribute("draw", draw);
        model.addAttribute("data",userInfoService.selectAll());
        //model.addAttribute("total", 100);
        //return model;
        return new ModelAndView("jsonView", model);
    }
}
