package demo1;


import cn.happy.hibernate0701duoduiyi.Dept;
import cn.happy.hibernate0701duoduiyi.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * Created by linlin on 2017/9/24.
 */
public class hqlTestguanlian {

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

//==========================多对一单向关联
    @Test
    public void geanlian() {
        Dept dept=new Dept();
        dept.setDeptname("开发部");
        Emp emp=new Emp();
        emp.setEnmae("苏苏");

        emp.setDept(dept);
        session.save(dept);
        session.save(emp);
        tx.commit();
    }
    @Test
    public void geanlian1() {
        Dept dept=new Dept();
        dept.setDeptname("测试部");
        Emp emp=new Emp();
        emp.setEnmae("苏苏3");

        emp.setDept(dept);
        session.save(dept);
        session.save(emp);
        tx.commit();
    }
    @Test
    public void selectEmpsByDeptId(){

        String hql="from Emp where dept.deptno=12";
       Query query= session.createQuery(hql);
          List<Emp> list= query.list();
        for (Emp item:list) {
            System.out.println(item);
        }
    }

    @Test
    public void selectEmpsInfo(){

        String hql="from Emp";
        Query query= session.createQuery(hql);
        List<Emp> list= query.list();
        for (Emp item:list) {
            System.out.println(item.getEnmae()+item.getDept().getDeptname());
        }
    }
    //修改员工编号我1的员工所属部门
    @Test
    public void updateDept(){
        Emp emp=session.load(Emp.class,1);
       Dept dept=session.get(Dept.class,14);

        emp.setDept(dept);
        tx.commit();
        session.close();

    }
}
