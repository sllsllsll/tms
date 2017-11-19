package demo1;

import cn.happy.hibernate0928zujian.Dept;
import cn.happy.hibernate0928zujian.EmpHomeAddress;
import cn.happy.hibernate0928zujian.EmpInfo;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by linlin on 2017/9/28.
 */
public class Test0928zujian {

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
    public void testAdd(){
        //创建一个员工对象
        EmpInfo emp=new EmpInfo();
        emp.setEname("张靓颖");

        //创建一个员工地址对象
        EmpHomeAddress address=new EmpHomeAddress();
        address.setEhomecity("北京");
        address.setEhomeprovince("北京");
        address.setEhomestreet("五道口");
        address.setEhomezipcode("100000");
        address.setEmpinfo(emp);
        emp.setEhome(address);
        session.save(emp);
        tx.commit();
        System.out.println("ok===");
    }

    @Test
    public void egj2(){
        Transaction tx1=factory.getCurrentSession().beginTransaction();
        factory.getCurrentSession().get(Dept.class,14);
        tx1.commit();
        System.out.println("================");
        Transaction tx2=factory.getCurrentSession().beginTransaction();
        factory.getCurrentSession().get(Dept.class,14);
        tx2.commit();
    }

    //查询缓存测试
    @Test
    public void selectcacheTest(){
        Session session1=factory.openSession();
Transaction tx1=session1.beginTransaction();
        List<Dept> list=session1.createQuery("from dept")
                .setCacheable(true).list();
        System.out.println(list.get(0).getDeptname());
        tx1.commit();

        Session session2=factory.openSession();
        Transaction tx2=session2.beginTransaction();
        List<Dept> list1=session2.createQuery("from dept")
                .setCacheable(true).list();
        System.out.println(list1.get(0).getDeptname());
        tx2.commit();

    }
}
