package cn.bayllech.controller;

import cn.bayllech.util.FastdfsUtil;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Author bei.qi
 * @Date 2017-08-21 9:46
 */
@Controller
public class HomeController {
    @RequestMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping("/list")
    public ModelMap userList() {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("msg");
        return modelMap;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap uploadPic(@RequestParam(value = "files") MultipartFile[] files) {
        ModelMap model = new ModelMap();
        List<String> urlList = Lists.newArrayList();
        for (MultipartFile file : files) {
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String contentType = file.getContentType();

            //获得文件后缀名称
            String imageName = contentType.substring(contentType.indexOf("/") + 1);
            String fileName = uuid + "." + imageName;

            //借助dfs上传文件

            try {
                byte[] bytes = file.getBytes();
                String url = FastdfsUtil.upload(bytes, fileName, file.getSize());
                urlList.add("127.0.0.1" + url);
                model.addAttribute("urlList", urlList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return model;
    }
}
