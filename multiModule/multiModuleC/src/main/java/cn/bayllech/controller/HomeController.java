package cn.bayllech.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author bei.qi
 * @Date 2017-08-30 15:20
 */
@RestController
public class HomeController {

    @RequestMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public ModelMap home(String loginNo,String pwd) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("loginNo", loginNo);
        modelMap.addAttribute("pwd", pwd);
        return modelMap;

    }

}
