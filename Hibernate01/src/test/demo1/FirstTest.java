package demo1;


import cn.happy.hibernate01.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by linlin on 2017/8/27.
 */
public class FirstTest {
    Configuration cfg;
    Transaction tx;
    Session session;
    @Before
    public void myBefore(){
        //创建配置对象
       cfg = new Configuration().configure("Hibernate.cfg.xml");
       //根据配置对象创建SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
       //根据SessionFactory创建Session
       session= factory.openSession();
        //在Session创建后开启事务
        tx = session.beginTransaction();
    }


@After
public void myafter(){
    tx.commit();
    session.close();
}

    @Test
    public void addTest(){
        Dog dog=new Dog();
        dog.setId(3);
        dog.setName("LB222");
        dog.setAge(4);
        session.save(dog);
        System.out.println(dog+"=======");
    }



    @Test
    public void updatetest03(){
        //修改
        Dog dog=session.load(Dog.class,2);
        dog.setName("susu22");
        //  session.update(dog);
    }

    @Test
    public void selecttest02(){
        Dog dog=session.get(Dog.class,3);
        System.out.println(dog.getName());
    }


    @Test
    public void selecttest022order(){
        Dog dog=session.get(Dog.class,2);
        System.out.println("=============");
        System.out.println(dog);
        System.out.println(dog.getName());

    }
@Test
public void delecttest04(){

        Dog dog=(Dog)session.load(Dog.class,2);
        session.delete(dog);
    System.out.println("删除成功");
}

    public static void main(String[] args) {
       // addtest01();
       // selecttest02();
        /*Class<Dog> clazz=Dog.class;
        System.out.println(clazz);*/
       // updatetest03();
    }


}
