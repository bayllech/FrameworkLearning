package cn.bayllech.controller;

import cn.bayllech.pojo.Song;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

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

    @RequestMapping("/data")
    @ResponseBody
    public ModelMap getData() {
        ModelMap modelMap = new ModelMap();
        Song song = new Song("001","优衣库",100L);
        Song song1 = new Song("002","电视",12100L);
        Song song2 = new Song("003","手机",1100L);
        List<Song> lists = Arrays.asList(song, song1, song2);
        modelMap.addAttribute("lists", lists);
        return modelMap;
    }
}
