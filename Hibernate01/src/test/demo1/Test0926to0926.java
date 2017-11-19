package demo1;



import cn.happy.hibernate0926to0926.Employee;
import cn.happy.hibernate0926to0926.Project;
import cn.happy.hibernate0926yiduiduo.Dept;
import cn.happy.hibernate0926yiduiduo.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by linlin on 2017/9/24.
 */
public class Test0926to0926 {

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

//==========================多对多关联
    @Test
    public void geanlian() {
        Employee emp1=new Employee();
        emp1.setEname("小萌萌");
        Employee emp2=new Employee();
        emp2.setEname("小可可");
        Project pro1=new Project();
        pro1.setProname("天2");
        pro1.getEmps().add(emp1);
        pro1.getEmps().add(emp2);
        session.save(pro1);
        tx.commit();
    }

}
