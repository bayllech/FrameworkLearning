package cn.bayllech.project.controller;

import cn.bayllech.project.eto.ConfigProperties;
import cn.bayllech.project.eto.ConsumerConfig;
import cn.bayllech.project.eto.RandomNum;
import cn.bayllech.project.pojo.LearnResouce;
import cn.bayllech.project.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-21 11:30
 */
@RestController
@RequestMapping("/leaf")
public class ThymeleafController {

/*    @Value("${consumer.bayllech.domain}")
    private String domain;*/

    @Autowired ConsumerConfig consumerConfig;
    
    @Autowired ConfigProperties configProperties;
    
    @Autowired RandomNum randomNum;
    
    @RequestMapping("")
    public String domain() {
        //return consumerConfig.getDomain() + ":" + consumerConfig.getPort();
        return configProperties.getAppname() + ":" + configProperties.getProtocol();
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map =new HashMap<String,Object>();
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        if(!userName.equals("") && password!=""){
            User user =new User(userName,password);
            request.getSession().setAttribute("user",user);
            map.put("result","1");
        }else{
            map.put("result","0");
        }
        return map;
    }
    
    @RequestMapping("random")
    public ModelMap random() {
        ModelMap model = new ModelMap();
        model.addAttribute("uuid: ", randomNum.getUuidOrigin());
        model.addAttribute("long: ", randomNum.getLongOrigin());
        model.addAttribute("intOrign", randomNum.getIntOrigin());
        model.addAttribute("intRange", randomNum.getIntRange());
        model.addAttribute("intLessthan", randomNum.getIntLessthan());
        model.addAttribute("randomValue", randomNum.getRandomstr());
    
/*        model.addAttribute("rand.str : " , randomNum.getRandStr());
        model.addAttribute("rand.intid : " , randomNum.getRandIntid());
        model.addAttribute("rand.longid : " , randomNum.getRandLongid());
        model.addAttribute("rand.number : " , randomNum.getRandNumber());
        model.addAttribute("rand.range : " , randomNum.getRandRange());*/

        return model;
    }
    
    @RequestMapping("list")
    public ModelAndView index(){
        List<LearnResouce> learnList =new ArrayList<LearnResouce>();
        LearnResouce bean =new LearnResouce("官方参考文档","Spring Boot Reference Guide","http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application");
        learnList.add(bean);
        bean =new LearnResouce("官方SpriongBoot例子","官方SpriongBoot例子","https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples");
        learnList.add(bean);
        bean =new LearnResouce("龙国学院","Spring Boot 教程系列学习","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new LearnResouce("嘟嘟MD独立博客","Spring Boot干货系列 ","http://tengj.top/");
        learnList.add(bean);
        bean =new LearnResouce("后端编程嘟","Spring Boot教程和视频 ","http://www.toutiao.com/m1559096720023553/");
        learnList.add(bean);
        bean =new LearnResouce("程序猿DD","Spring Boot系列","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new LearnResouce("纯洁的微笑","Sping Boot系列文章","http://www.ityouknow.com/spring-boot");
        learnList.add(bean);
        bean =new LearnResouce("CSDN——小当博客专栏","Sping Boot学习","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new LearnResouce("梁桂钊的博客","Spring Boot 揭秘与实战","http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new LearnResouce("林祥纤博客系列","从零开始学Spring Boot ","http://412887952-qq-com.iteye.com/category/356333");
        learnList.add(bean);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }
    
}
