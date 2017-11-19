package cn.happy.test;


import cn.happy.hibernate01.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by linlin on 2017/9/22.
 */
public class test0922 {
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
        dog.setName("卡卡2");
        dog.setAge(2);
        session.save(dog);
        tx.commit();
        System.out.println("添加成功！！！");
        session.close();
    }

    @Test
    public void test02() {

        Cat cat = session.load(Cat.class, 5);
        System.out.println(cat.getName());
        session.close();
        System.out.println("save ok!");
    }

    @Test
    public void test03() {

        Cat cat = (Cat) session.load(Cat.class, new Integer("8"));
        cat.setName("呵呵1");
        cat.setName("呵呵2");
        tx.commit();
        System.out.println("save ok!");
    }

    @Test
    public void test05() {

        Cat cat = (Cat) session.load(Cat.class, new Integer("5"));
        session.delete(cat);
        tx.commit();
        System.out.println("del ok!");
    }
}
