package cn.bayllech.controller;

import cn.bayllech.pojo.Song;
import cn.bayllech.pojo.User;
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

    @RequestMapping("/")
    public String userList(){
        return "datagridCRUD";
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public List<User> getUserList() {
        User user1 = new User("张三", "小野猫", "020-324325", "3242342@qq.com");
        User user2 = new User("李四", "大怪兽", "020-324325", "3242342@qq.com");
        User user3 = new User("tom", "singleDog", "020-324325", "3242342@qq.com");
        List<User> users = Arrays.asList(user1, user2, user3);
        return users;
    }



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

    @RequestMapping("getCCData")
    @ResponseBody
    public String getCCData() {
        String s = "[{\"id\":1,\"text\":\"text1\"},{\"id\":2,\"text\":\"text2\"},{\"id\":3,\"text\":\"text3\",\"selected\":true},{\"id\":4,\"text\":\"text4\"},{\"id\":5,\"text\":\"text5\"}]";
        return s;
    }

    @RequestMapping("getTreeData")
    @ResponseBody
    public String getTreeData() {
        String s = "[{    \n" +
                "    \"id\": 1,    \n" +
                "    \"text\": \"Node 1\",    \n" +
                "    \"state\": \"closed\",    \n" +
                "    \"children\": [{    \n" +
                "        \"id\": 11,    \n" +
                "        \"text\": \"Node 11\"   \n" +
                "    },{    \n" +
                "        \"id\": 12,    \n" +
                "        \"text\": \"Node 12\"   \n" +
                "    }]    \n" +
                "},{    \n" +
                "    \"id\": 2,    \n" +
                "    \"text\": \"Node 2\",    \n" +
                "    \"state\": \"closed\"   \n" +
                "}]  ";
        return s;
    }
}
