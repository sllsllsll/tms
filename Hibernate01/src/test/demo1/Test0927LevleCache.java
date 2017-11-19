package demo1;

import cn.happy.hibernate0927levelCache.Dept;

import cn.happy.hibernate0927levelCache.Emp;
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
public class Test0927LevleCache {

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

//==========================一级缓存测试

    @Test
    public void geanlian() {
      String hql="from Dept";
     List<Dept> list= session.createQuery(hql).list();
  for (Dept item:list){
      System.out.println(item.getDeptname()+" "+item.getDeptno());
  }
        System.out.println("====================");
        Dept dept = session.get(Dept.class, 12);
        System.out.println(dept.getDeptname());
    }
    @Test
    public void sessioniterator() {
        String hql="from Dept";
        Iterator<Dept> iterate = session.createQuery(hql).iterate();
       while (iterate.hasNext()) {
           Dept dept = iterate.next();
           System.out.println(dept.getDeptname());
       }
        System.out.println("==================================================");

        Iterator<Dept> iterate2 = session.createQuery(hql).iterate();
        while (iterate2.hasNext()) {
            Dept dept = iterate2.next();
            System.out.println(dept.getDeptname());
        }
    }

    //延迟加载  立即加载。。。
    @Test
    public void lazy01(){

        String hql="from Dept";
        Dept d=session.load(Dept.class,14);
        System.out.println(d.getDeptname());
    }
    @Test
    public void lazy02(){
        Dept dept=session.load(Dept.class,14);
        Emp emp=new Emp();
        emp.setEname("TOM");
        emp.setDept(dept);
        session.save(emp);
        tx.commit();
    }

    @Test
    public void initliza(){
        Dept dept=session.load(Dept.class,14);
        if(!Hibernate.isInitialized(dept)){
            Hibernate.initialize(dept);
        }
        tx.commit();
    }

    @Test
    public void iniza(){
       List list=session.createQuery("from dept").list();
        tx.commit();
    }

    @Test
    public void iniza2(){
        Dept dept=session.load(Dept.class,14);
        tx.commit();
    }
}
