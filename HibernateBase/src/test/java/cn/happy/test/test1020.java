package cn.happy.test;


import cn.happy.hibernate17.Dept;
import cn.happy.hibernate17.Emp;
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
public class test1020 {
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

    //内连接
    @Test
    public void Test01() {
      List<Dept> list = session.createQuery("select distinct d from Dept d inner join d.emps").list();
      for (Dept dept : list) {
          System.out.println(dept.getDeptname());
          for (Emp emp:dept.getEmps()){
              System.out.println(emp.getEnmae());
          }
      }
      tx.commit();
  }
    @Test
    public void Test011() {
        List<Object[]> list = session.createQuery("select d,e from Dept d,Emp e where d.deptno=e.deptno").list();
        for (Object[] dept : list) {
            System.out.println(dept[0]);

        }
        tx.commit();
    }
  //隐式内连接
  @Test
  public void Test02() {
      List<Emp> list = session.createQuery("from Emp e where e.dept.deptname='哈哈哈'").list();
      for (Emp emp : list) {
          System.out.println(emp.getEnmae());
      }
      tx.commit();
  }

  //子查询  查询 工资少于5000的
  @Test
  public void Test03() {
      List<cn.happy.hibernate18.Dept> list = session.createQuery("from Dept d where 5000>all(select e.empno from d.emps e)").list();
      for (cn.happy.hibernate18.Dept emp : list) {
          System.out.println(emp.getDeptname());
      }
      tx.commit();
  }

}

