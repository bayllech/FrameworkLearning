package cn.bayllech.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author bei.qi
 * @Date 2017-08-21 9:46
 */
@RestController
public class HomeController {


    @RequestMapping("/list")
    public ModelMap userList() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("msg", "msg");
        return modelMap;
    }
}
