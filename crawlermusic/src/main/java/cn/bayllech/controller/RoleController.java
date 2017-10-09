package cn.bayllech.controller;

import cn.bayllech.pojo.Role;
import cn.bayllech.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author bei.qi
 * @Description
 * @Date 2017-10-09 11:25
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("showRoleList")
    public ModelAndView showRoleList() {
        ModelMap modelMap = new ModelMap();
        return new ModelAndView("role/roleList");
    }

    @RequestMapping("getRoleList")
    public ModelAndView getUserList(String roleName, Integer rows, Integer page) {
        ModelMap modelMap = new ModelMap();
        int total = roleService.findTotal(roleName);
        List<Role> list = roleService.findByPage(roleName,(page-1)*rows,rows);
        modelMap.addAttribute("total", total);
        modelMap.addAttribute("rows", list);
        return new ModelAndView("jsonView", modelMap);
    }
}
