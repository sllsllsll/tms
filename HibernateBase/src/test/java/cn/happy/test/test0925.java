package cn.happy.test;


import cn.happy.hibernate01.Cat;
import cn.happy.hibernate02.Dept;
import cn.happy.hibernate03hql.Emp;
import cn.happy.hibernate03hql.conEmp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by linlin on 2017/9/22.
 */
public class test0925 {
    Configuration cfg;
    Transaction tx;
    Session session;
    SessionFactory factory;
    @Before
    public void myBefore(){
        //创建配置对象
        cfg = new Configuration().configure("Hibernate.cfg.xml");
        //根据配置对象创建SessionFactory
       factory = cfg.buildSessionFactory();
        //根据SessionFactory创建Session
        session= factory.openSession();
        //在Session创建后开启事务
        tx = session.beginTransaction();
    }

    @Test
    public void test01() {

        Cat dog = new Cat();
        dog.setName("哈哈2");
        dog.setAge(2);
        session.save(dog);
        session.close();
        System.out.println("添加成功！！！");

    }

    @Test
    public void test03() {

        Cat dog = new Cat();
       dog.setId(8);
        dog.setName("苏us");
        dog.setAge(11);
        session.saveOrUpdate(dog);
        tx.commit();
        session.close();
        System.out.println("ok！！！");

    }

    @Test
    public void test0333() {

        Dept dog = new Dept();
        dog.setDeptno(2);
        dog.setDeptname("保洁部");
        session.save(dog);
        tx.commit();
        session.close();
        System.out.println("ok！！！");

    }
//查询所有
    @Test
    public void test0select() {

    String hql="from Dept";
        Query query = session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept item:list){
            System.out.println(item.getDeptname());
        }
        System.out.println("ok");
    }
//检索部分记录
    @Test
    public void test0sel8ct() {

        String hql="from Dept where deptname='开发部'";
        Query query = session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept item:list){
            System.out.println(item.getDeptname());
        }
        System.out.println("ok");
    }

    @Test
    public void test8ct() {

        String hql="select deptname from Dept";
        Query query = session.createQuery(hql);
        List<Dept> list=query.list();
        System.out.println(list);
        System.out.println("ok");
    }
    //部分多列
    @Test
    public void test0sel8() {

        String hql="select deptno,deptname from Dept";
        Query query = session.createQuery(hql);
        List<Object[]> list=query.list();
        for (Object[] item:list){
            for (Object child:item)
            System.out.println(child);
        }
        System.out.println("ok");
    }
//检索部分集合 强类型
    @Test
    public void testl8() {

        String hql="select new Dept(deptno,deptname) from Dept";
        Query query = session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept item:list){
            System.out.println(item.getDeptname());
        }
        System.out.println("ok");
    }

    @Test
    public void testl834() {

        String hql="from Dept where deptname=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,"开发部");
        List<Dept> list=query.list();
        for (Dept item:list){
            System.out.println(item.getDeptname());
        }
        System.out.println("ok");
    }

    @Test
    public void testl() {

        String hql="from Dept where deptname=:deptname";
        Query query = session.createQuery(hql);
        query.setParameter("deptname","开发部");
        List<Dept> list=query.list();
        for (Dept item:list){
            System.out.println(item.getDeptname());
        }
        System.out.println("ok");
    }
    @Test
    public void test4() {

        String hql="from Dept dept where dept.deptname=deptname";
        Query query = session.createQuery(hql);
     Dept dd=new Dept();
     dd.setDeptname("开发部");
     query.setProperties(dd);
        List<Dept> list=query.list();
        for (Dept item:list){
            System.out.println(item.getDeptname());
        }
        System.out.println("ok");
    }

    //动态查询
    @Test
    public void testselect() {
      conEmp c=new conEmp();
      c.setSal(1000L);
      c.setJob("CLERK");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date fromdate=null;
        Date enddate=null;
        try {
            fromdate=sdf.parse("1981-04-01");
            enddate=sdf.parse("1985-09-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setHiredateEnd(enddate);
        c.setHiredateStart(fromdate);
        String hql="from Emp where 1=1 ";
        StringBuffer sb=new StringBuffer(hql);
        if(c.getJob()!=null){
            sb.append(" and job=:job ");
        }
        if(c.getSal()!=null){
            sb.append(" and sal>:sal ");
        }
        if(c.getHiredateStart()!=null){
            sb.append(" and hiredate>=:hiredateStart ");
        }
        if(c.getHiredateEnd()!=null){
            sb.append(" and hiredate<=:hiredateEnd ");
        }
        Query query = session.createQuery(sb.toString());
        query.setProperties(c);
        List<Emp> list=query.list();
        for (Emp item:list){
            System.out.println(item.getEmpno());
        }
    }
}

