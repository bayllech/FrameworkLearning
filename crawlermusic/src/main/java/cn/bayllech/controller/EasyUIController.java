package cn.bayllech.controller;

import cn.bayllech.pojo.ComobboText;
import cn.bayllech.pojo.Song;
import cn.bayllech.pojo.User;
import com.google.common.collect.Lists;
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
@RequestMapping("/easyui")
public class EasyUIController {

    @RequestMapping("")  //todo 必须有值，即使为空也要加上"";如果为"/"，则请求地址需多个/;否则css,js等无法加载
    public String userList(){
        return "easyUI/datagridCRUD";
    }

   /* @RequestMapping("/getUserList")
    @ResponseBody
    public List<User> getUserList() {
        User user1 = new User(1,"张三", "小野猫", "020-324325", "3242342@qq.com");
        User user2 = new User(2,"李四", "大怪兽", "020-324325", "3242342@qq.com");
        User user3 = new User(3,"tom", "singleDog", "020-324325", "3242342@qq.com");
        List<User> users = Arrays.asList(user1, user2, user3);
        return users;
    }*/

  /*  @RequestMapping("getJson")
    @ResponseBody
    public ModelMap getJson() {  //todo 返回值为Json对象 {attribute对象1:[对象1，对象3],attribute对象2}
        ModelMap model = new ModelMap();
        User user = new User(1,"李四", "大怪兽", "020-324325", "3242342@qq.com");
        User user1 = new User(2,"张三", "小野猫", "020-324325", "3242342@qq.com");
        List<User> users = Lists.newArrayList(user, user1);
        model.addAttribute("users",users);
        User user3 = new User(3,"tom", "singleDog", "020-324325", "3242342@qq.com");
        model.addAttribute("user", user3);
        return model;
    }*/

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
    public List<ComobboText> getCCData() { //TODO 返回值为Json数组  [对象1,对象2]
        ComobboText comobboText1 = new ComobboText("1", "选项1");
        ComobboText comobboText2 = new ComobboText("2", "选项2");
        ComobboText comobboText3 = new ComobboText("3", "选项3");
//        String s = "[{\"id\":1,\"text\":\"text1\"},{\"id\":2,\"text\":\"text2\"},{\"id\":3,\"text\":\"text3\",\"selected\":true},{\"id\":4,\"text\":\"text4\"},{\"id\":5,\"text\":\"text5\"}]";
        List<ComobboText> list = Lists.newArrayList(comobboText1,comobboText2,comobboText3);
        return list;
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
