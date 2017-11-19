package demo1;



import cn.happy.hibernate0926yiduiduo.Dept;
import cn.happy.hibernate0926yiduiduo.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * Created by linlin on 2017/9/24.
 */
public class Test0926yiduiduo {

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

//==========================一对多单向关联
    @Test
    public void geanlian() {
        Dept dept=new Dept();
        dept.setDeptname("研发5部");

        Emp emp=new Emp();
        emp.setEnmae("king");
        emp.setDept(dept);
       dept.getEmps().add(emp); //这个加不加没区别
        session.save(dept);
     //  session.save(emp);
        tx.commit();
    }

}
