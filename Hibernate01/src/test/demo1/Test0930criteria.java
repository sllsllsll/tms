package demo1;

import cn.happy.hibernate0930Criteria.Student;
import cn.happy.hibernate0930zujie.Dept;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by linlin on 2017/9/30.
 */
public class Test0930criteria {
    Configuration cfg;
    Transaction tx;
    Session session;

    @Before
    public void myBefore() {
        //创建配置对象
        cfg = new Configuration().configure("Hibernate1.cfg.xml");
        //根据配置对象创建SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
        //根据SessionFactory创建Session
        session = factory.openSession();
        //在Session创建后开启事务
        tx = session.beginTransaction();
    }

    @Test
    public void Test01()
    {
        Criteria criteria=session.createCriteria(Student.class);
        List<Student> list=criteria.list();
        for(Student item:list){
            System.out.println(item.getStuname());
        }
    }
}
