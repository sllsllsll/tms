package cn.happy.controller;

import cn.happy.beans.account;
import cn.happy.service.IAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by linlin on 2017/10/13.
 */
@Controller
public class AccountController {
    @Resource(name="IAccountService")
    private IAccountService accountService;

 /*   @RequestMapping("/login")
    public String login(account a){
        accountService.login(a);
        return "index";
    }*/
//登录
    @RequestMapping("/welcome")
    public String login(String account_number , String password){
        System.out.println(account_number);
        int islogin = accountService.islogin(account_number, password);
        return "money";
    }
    //转账
    @RequestMapping("/update")
    public String update(int balance,String account_number){
        System.out.println("===============");
        System.out.println(account_number);
        System.out.println(balance);
        boolean flag=false;
        accountService.updatemoneys(balance,account_number,flag);
        return "success";
    }

    //转账2
    @RequestMapping("/updates")
    public String update2(int balance,String account_number){
        System.out.println("===============");
        System.out.println(account_number);
        System.out.println(balance);
        accountService.update(balance,account_number);
        return "success";
    }

    public IAccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

}
