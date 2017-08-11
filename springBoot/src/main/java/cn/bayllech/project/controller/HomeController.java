package cn.bayllech.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author bei.qi
 * @Date 2017-08-10 15:10
 */
@Controller
public class HomeController {

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

}
