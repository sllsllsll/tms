package cn.happy.test;



import cn.happy.hibernate09manytomany.Employee;
import cn.happy.hibernate09manytomany.Project;
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
public class test1006_02 {
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
    public void test03() {
        Employee emp=session.get(Employee.class,1);
        System.out.println(emp.getEmpname());
        System.out.println("============");
        for(Project pro:emp.getProjects()){
            System.out.println(pro.getProname());
        }
    }
    @Test
    public void addTest(){
        //雇员对象
        Employee emp1=new Employee();
        emp1.setEmpname("张三8");
        //雇员对象
        Employee emp2=new Employee();
        emp2.setEmpname("李四8");
        //项目对象
        Project pro1=new Project();
        pro1.setProname("海淀花园8");
        //项目一方，主的一方。
        pro1.getEmployees().add(emp1);
        pro1.getEmployees().add(emp2);
        emp1.getProjects().add(pro1);
        emp2.getProjects().add(pro1);
        session.save(pro1);
        session.save(emp1);
        session.save(emp2);
        tx.commit();
    }

}

