package cn.happy.service;

import cn.happy.beans.account;

/**
 * Created by linlin on 2017/10/13.
 */
public interface IAccountService {
/*    public int login(account a);*/
    public int islogin(String account_number,String password);
    public void update(int balance,String account_number);
    public void updatemoneys(int balance,String account_number,boolean flag);
}
