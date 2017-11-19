package cn.tms.controller;


import cn.tms.entity.Privilege;
import cn.tms.entity.Role;
import cn.tms.entity.UserInfo;

import cn.tms.service.IPrivilegeService;
import cn.tms.service.IRoleService;
import cn.tms.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Happy on 2017-08-21.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    //植入用户的service
    @Resource(name = "roleService")
    IRoleService roleService;

    IPrivilegeService privilegeService;



/*    @ResponseBody
    @RequestMapping("/roleListFP")
    public Object roleListFP(HttpServletRequest request, HttpSession session, Model model) {
        List<Role> roles = roleService.UserRoleList();
        return roles;
    }*/


    @ResponseBody
    //获取单页用户数据
    @RequestMapping("/RoleList")
    public Object selectRole(@RequestParam(defaultValue = "1",value = "page") int pageIndex, @RequestParam(defaultValue = "2",value = "rows") int pageSize, UserInfo info){
        Map<String,Object> map=new HashMap<String,Object>();
        PageUtil pp=null;
        if (info==null||info.getUsername()==null){
            pp=roleService.RoleList(pageIndex-1,pageSize);

        }else{
            pp= roleService.getOnePageData(pageIndex-1,pageSize,info);
        }
        Integer total = pp.getTotalRecords();
        map.put("total",total);
        map.put("rows",pp.getList());
        return map;
    }



    @ResponseBody
    @RequestMapping("/findAllRoles")
    public Object getAllRolse(){
        List<Role> allRoles = this.roleService.getAllRoles();
        return  allRoles;
    }


    @ResponseBody
    @RequestMapping("/addRoleForUser")
    public String addRoleByUserId(Integer userid, Integer roleid){
        System.out.println(userid+"===============userid  ==");
        System.out.println(roleid+"===============roleid  ==");
        this.roleService.AddRoleForUser(userid,roleid);
        return "y";
    }

    public IRoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }
}


