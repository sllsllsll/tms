package demo1;

import cn.happy.hibernateManytoManyDouble.Employee;
import cn.happy.hibernateManytoManyDouble.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by linlin on 2017/9/24.
 */
public class TestManytoMany {

    Configuration cfg;
    Transaction tx;
    Session session;

    @Before
    public void myBefore() {
        //创建配置对象
        cfg = new Configuration().configure("HibernateManytoMany.cfg.xml");
        //根据配置对象创建SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
        //根据SessionFactory创建Session
        session = factory.openSession();
        //在Session创建后开启事务
        tx = session.beginTransaction();
    }

//==========================多对多关联
    @Test
    public void geanlian() {
        Employee emp1=new Employee();
        emp1.setEname("狗蛋");
        Employee emp2=new Employee();
        emp2.setEname("二虎");
        Project pro1=new Project();
        pro1.setProname("搬砖");
        pro1.getEmps().add(emp1);
        pro1.getEmps().add(emp2);

        session.save(pro1);
        tx.commit();
    }

}
