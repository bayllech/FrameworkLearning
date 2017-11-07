package cn.bayllech.project.controller;

import cn.bayllech.project.pojo.TUserInfo;
import cn.bayllech.project.pojo.TUserInfoExample;
import cn.bayllech.project.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-11-01 10:29
 */
@RestController
@RequestMapping("/info")
public class UserInfoController {
    
    @Autowired
    private UserInfoService userInfoService;
    
    @RequestMapping("")
    public ModelAndView infoView() {
        return new ModelAndView("user/userInfoList");
    }
    
    
    @RequestMapping("info.json")
    public ModelMap info(Integer p, Integer pageSize, String sortName, String sortOrder,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) Integer sex) {
        //String draw = request.getParameter("draw");
        ModelMap model = new ModelMap();
/*        model.addAttribute("recordsTotal", 100);
        model.addAttribute("recordsFiltered", 100);
        model.addAttribute("draw", draw);*/
        //model.addAttribute("data",userInfoService.selectAll());
        TUserInfoExample userInfoExample = new TUserInfoExample();
        if (StringUtils.isNotBlank(name)) {
            userInfoExample.createCriteria().andNameLike("%" + name + "%");
        }
        if (null != sex) {
            userInfoExample.createCriteria().andSexEqualTo(sex);
        }
        
        userInfoExample.setOffset((p-1)*pageSize);
        userInfoExample.setLimit(pageSize);
        userInfoExample.setOrderByClause(sortName + " " + sortOrder);
        
        List<TUserInfo> list = userInfoService.selectByExample(userInfoExample);
        Long total = userInfoService.selectTotal(userInfoExample);
        
        //model.addAttribute("rows",userInfoService.selectByPage((p-1)*pageSize,pageSize,sortName,sortOrder));
        model.addAttribute("rows",list);
        //model.addAttribute("total", userInfoService.selectTotal((p-1)*pageSize,pageSize));
        model.addAttribute("total", total);
        
        return  model;
    }
    
    @RequestMapping("/toAdd")
    public ModelMap toAdd(TUserInfo userInfo) {
        ModelMap model = new ModelMap();
        userInfoService.addUser(userInfo);
        
    
        return model;
    }
    
    @RequestMapping("/getUser")
    public ModelMap getUser(Integer id) {
        ModelMap model = new ModelMap();
        TUserInfoExample userInfoExample = new TUserInfoExample();
        userInfoExample.createCriteria().andIdEqualTo(id);
        model.addAttribute("userInfo", userInfoService.selectByExample(userInfoExample).get(0));
        
        
        return model;
    }
    
    @RequestMapping("/toEdit")
    public ModelMap toEdit(TUserInfo userInfo) {
        ModelMap model = new ModelMap();
        userInfoService.toEdit(userInfo);
        
        return model;
    }
    
    @RequestMapping("/del")
    public ModelMap del(Integer id) {
        ModelMap model = new ModelMap();
        userInfoService.del(id);
        
        return model;
    }
    //remote修改
    //本地 修改
}
