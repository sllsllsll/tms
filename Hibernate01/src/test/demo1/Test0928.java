package demo1;

import cn.happy.hibernate0927levelCache.Dept;
import cn.happy.hibernate0927levelCache.Emp;
import cn.happy.hibernate0928.Resume1;
import cn.happy.hibernate0928.Users1;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;


/**
 * Created by linlin on 2017/9/24.
 */
public class Test0928 {

    Configuration cfg;
    Transaction tx;
    Session session;

    @Before
    public void myBefore() {
        //创建配置对象
        cfg = new Configuration().configure("Hibernate.cfg.xml");
        //根据配置对象创建SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
        //根据SessionFactory创建Session
        session = factory.openSession();
        //在Session创建后开启事务
        tx = session.beginTransaction();
    }

@Test
    public void text01(){
  Users1 u1=new Users1("happy11","21");
  Resume1 r1=new Resume1("入职档案1","happy011");
u1.setResume1(r1);
r1.setUsers1(u1);
session.save(r1);
tx.commit();
}
}
