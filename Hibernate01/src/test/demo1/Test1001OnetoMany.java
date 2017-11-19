package demo1;

import cn.happy.hibernate1001zujie2.Emp;
import cn.happy.hibernate1001zujie2.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by linlin on 2017/9/30.
 */
public class Test1001OnetoMany {
    Configuration cfg;
    Transaction tx;
    Session session;
    SessionFactory factory;

    @Before
    public void myBefore() {
        //创建配置对象
        cfg = new Configuration().configure("Hibernate1.cfg.xml");
        //根据配置对象创建SessionFactory
        factory = cfg.buildSessionFactory();
        //根据SessionFactory创建Session
        session = factory.openSession();
        //在Session创建后开启事务
        tx = session.beginTransaction();
    }

    //注解 的 多对多
    @Test
    public void Test01add() {

        Dept dept = new Dept();
        dept.setDname("财务部");
        Emp emp = new Emp();
        emp.setEname("大大");
        dept.getEmps().add(emp);
        emp.setDept(dept);
        session.save(dept);
        tx.commit();

    }

    @Test
    public void Test01add2() {
        Dept dept = session.get(Dept.class, 10045);
        System.out.println(dept.getDname());
        System.out.println(dept.getEmps().iterator().next().getEname());
    }
}
