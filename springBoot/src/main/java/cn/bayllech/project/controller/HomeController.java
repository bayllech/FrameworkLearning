package cn.bayllech.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author bei.qi
 * @Date 2017-08-10 15:10
 */
@RestController
public class HomeController {

    @RequestMapping()
    public String home() {
        ModelMap model = new ModelMap();
        model.addAttribute("msg", "1");

        return "Hello SpringBoot";
    }

}
