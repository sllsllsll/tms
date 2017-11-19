package cn.tms.controller;

import cn.tms.entity.Privilege;
import cn.tms.service.IPrivilegeService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/30.
 */
@Controller
@RequestMapping("/privilege")
public class PrivilegeController {

    @Resource(name="privilegeService")
    private IPrivilegeService privilegeService;


  /*  @ResponseBody
    @RequestMapping("/allPrivilege")
    public Object allPrivilege(){
        //查询所有的权限
        List<Privilege> allPrivilege = this.privilegeService.PrivilegeListAll();
        return  allPrivilege;
    }*/

    public IPrivilegeService getPrivilegeService() {
        return privilegeService;
    }

    public void setPrivilegeService(IPrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }
}
