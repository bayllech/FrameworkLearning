package cn.bayllech.controller;

import cn.bayllech.pojo.Song;
import cn.bayllech.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
        return "easyUI/datagridCRUD";
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public List<User> getUserList() {
        User user1 = new User(1,"张三", "小野猫", "020-324325", "3242342@qq.com");
        User user2 = new User(2,"李四", "大怪兽", "020-324325", "3242342@qq.com");
        User user3 = new User(3,"tom", "singleDog", "020-324325", "3242342@qq.com");
        List<User> users = Arrays.asList(user1, user2, user3);
        return users;
    }

    @PostMapping("saveUser")
    @ResponseBody
    public ModelMap saveUser(String firstname, String lastname, String phone, String email) {
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(phone);
        System.out.println(email);
        ModelMap modelMap = new ModelMap();
        if (firstname == null) {
            modelMap.addAttribute("errorMsg", "error");
        }
        return modelMap;
    }

    @PostMapping("destroyUser")
    @ResponseBody
    public ModelMap destroyUser(Integer id) {
        System.out.println(id);
        ModelMap modelMap = new ModelMap();
        if (id != null) {
            modelMap.addAttribute("errorMsg", "error");
        } else {
            modelMap.addAttribute("success", "success");
        }
        return modelMap;
    }

    @RequestMapping("updateUser")
    public void updateUser(@RequestParam("id") Integer id) {
        System.out.println(id);
    }


    @GetMapping("/easyui")
    public String easyui() {
        return "easyUI/easyUI";
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
