package cn.happy.test;


import cn.happy.hibernate08save.Dept;
import cn.happy.hibernate08save.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by linlin on 2017/9/22.
 */
public class test1006_01 {
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
    public void testl8() {
        Dept dept=new Dept();
        dept.setDeptname("研发部2");
        Emp emp=new Emp();
        emp.setEname("苏苏3");
        emp.setDept(dept);
        dept.getEmps().add(emp);
        session.save(dept);
        tx.commit();
        System.out.println("保存成功");
    }

    @Test
    public void test03() {
        String hql = "from Emp e where e.dept.deptno=14";
        Query query = session.createQuery(hql);
        List<Emp> list = query.list();
        for (Emp item : list) {
            System.out.println(item.getEname());
        }
        tx.commit();
        session.close();
    }

    @Test
    public void test2() {
        Dept dept = session.get(Dept.class, 14);
        for (Emp emp : dept.getEmps()) {
            System.out.println(emp.getEname());
        }
    }

}

