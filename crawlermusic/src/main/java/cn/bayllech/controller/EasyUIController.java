package cn.bayllech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-18 10:02
 */
@Controller
public class EasyUIController {

    @GetMapping("/easyui")
    public String easyui() {
        return "easyUI";
    }
}
