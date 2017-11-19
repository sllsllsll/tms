package cn.happy.test;


import cn.happy.hibernate11lazyLoad.Dept;
import cn.happy.hibernate11lazyLoad.Emp;
import cn.happy.hibernate11lazyLoad.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by linlin on 2017/9/22.
 */
public class test1009 {
    Configuration cfg;
    Transaction tx;
    Session session;
    SessionFactory factory;

    @Before
    public void myBefore() {
        //创建配置对象
        cfg = new Configuration().configure("Hibernate.cfg.xml");
        //根据配置对象创建SessionFactory
        factory = cfg.buildSessionFactory();
        //根据SessionFactory创建Session
        session = factory.openSession();
        //在Session创建后开启事务
        tx = session.beginTransaction();
    }


    @Test
    public void testmanyToOne() {
        Dept dept = session.get(Dept.class, 14);
        Set<Emp> emps = dept.getEmps();
        emps.size();
    }

    @Test
    public void testmanyToOne0() {
        Student student = session.load(Student.class, 1);
    }



}

