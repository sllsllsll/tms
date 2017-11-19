package cn.happy.test;



import cn.happy.hibernate04pagelist.Emp;
import cn.happy.hibernate05util.HibernateUtil;
import cn.happy.hibernate07onttomany.Dept;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by linlin on 2017/9/22.
 */
public class test1006 {
    Configuration cfg;
    Transaction tx;
    Session session;
    SessionFactory factory;
    @Before
    public void myBefore(){
        //创建配置对象
        cfg = new Configuration().configure("Hibernate.cfg.xml");
        //根据配置对象创建SessionFactory
        factory = cfg.buildSessionFactory();
        //根据SessionFactory创建Session
        session= factory.openSession();
    /*    Session session1= HibernateUtil.getSession();
        System.out.println(session);
        System.out.println(session1);*/
        //在Session创建后开启事务
        tx = session.beginTransaction();
    }

//分页
    @Test
    public void testl8() {

        String hql="from Emp";
        Query query = session.createQuery(hql);
            int pageindex=2;
            int pagesize=3;
            query.setFirstResult((pageindex-1)*pagesize);
            query.setMaxResults(pagesize);
        List<Emp> list=query.list();
        for (Emp item:list){
            System.out.println(item.getEmpname());
        }
    }
//多对一
    @Test
    public void testmanyToOne(){
        cn.happy.hibernate06mapping.Emp emp=session.get(cn.happy.hibernate06mapping.Emp.class,1);
        System.out.println(emp.getDept().getDeptname());
    }
//一对多双向关联
    @Test
    public void testmanytomany(){
List<Dept> list=session.createQuery("from Dept").list();
for(Dept dept:list){
    System.out.println(dept.getDeptname());
    for(cn.happy.hibernate07onttomany.Emp emp:dept.getEmps()){
        System.out.println(emp.getEnmae());
    }
}

    }

}

