package cn.happy.dao;

import cn.happy.beans.account;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by linlin on 2017/10/13.
 */
@Transactional
@Repository("IAccountDao")
public class AccountDaoImpl  implements IAccountDao{
  @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
  /*  public int login(account a) {
       System.out.println("=====daoimpl");
       String hql="select account_number ,password from account " +
               "where account_number='"+a.getAccount_number()+"' " +
               "and password = '"+a.getPassword()+"' AND status=1";
       System.out.println(hql+"=========hql");
       Serializable count = sessionFactory.getCurrentSession().save(hql);
       System.out.println(count);
       return (Integer) count;
    }*/

    public int islogin(String account_number, String password) {

        String hql="select user.username ,user.password from account as user where user.username='"+account_number+"' and user.password = '"+password+"' and status=1";
        System.out.println(hql);
        Serializable count = sessionFactory.getCurrentSession().save(hql);
        System.out.println(count);
        return (Integer) count;
    }

    public void update(int balance, String account_number) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update account d set d.balance=:bbalance where d.account_number=:aaccount_number")
                .setParameter("bbalance", balance)
                .setParameter("aaccount_number", account_number)
                .executeUpdate();

    }

    public void updatemoneys(int balance, String account_number, boolean flag) {
        Session session = sessionFactory.getCurrentSession();
        String hql="update account ";
        StringBuilder b=new StringBuilder(hql);
        if(flag){
            b.append(" set balance=balance+? ");
        }else{
            b.append("  set balance=balance-? ");
        }
        b.append(" where account_number=?");
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(b.toString());
        query.setParameter(1,account_number);
        query.setParameter(0,balance);
        int update=query.executeUpdate();
        System.out.println(update);

    }

}
