package cn.bayllech.controller;

import cn.bayllech.pojo.ComobboText;
import cn.bayllech.pojo.Song;
import cn.bayllech.pojo.User;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-09-18 10:02
 */
@Controller
public class EasyUIController {

    @RequestMapping("")  //todo 必须有值，即使为空也要加上"";如果为"/"，则请求地址需多个/;否则css,js等无法加载
//测试
    public String userList(){
        return "datagridCRUD";
    }
