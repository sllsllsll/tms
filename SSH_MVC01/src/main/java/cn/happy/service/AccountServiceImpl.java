package cn.happy.service;

import cn.happy.beans.account;
import cn.happy.dao.IAccountDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by linlin on 2017/10/13.
 */
@Transactional
@Service("IAccountService")
public class AccountServiceImpl implements IAccountService{
    @Resource(name="IAccountDao")
    private IAccountDao dao;

//    public int login(account a) {
//        int result=dao.login(a);
//        return result;
//    }

    public int islogin(String account_number, String password) {
        int login = dao.islogin(account_number, password);
     return login;
    }

    public void update(int balance, String account_number) {
        dao.update(balance,account_number);
    }

    public void updatemoneys(int balance, String account_number, boolean flag) {
        dao.updatemoneys(balance,account_number,flag);
    }

    public IAccountDao getDao() {
        return dao;
    }

    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }
}
