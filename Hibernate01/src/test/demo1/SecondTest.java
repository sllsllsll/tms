package demo1;

import cn.happy.hibernate01.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by linlin on 2017/9/20.
 */
public class SecondTest {

    @Test
    public void test01(){
        //添加
        Configuration cfg=new Configuration().configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Dog dog=new Dog();
        dog.setName("啦啦2");
        dog.setAge(2);
        session.save(dog);
        tx.commit();
        System.out.println("添加成功！！！");
        session.close();
    }
    //查询
    @Test
    public void test02() {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Dog dog = (Dog) session.load(Dog.class, new Integer(3));
        System.out.println(dog.getName());
        tx.commit();
        session.close();
    }
    //修改
    @Test
    public void test03() {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Dog dog = (Dog) session.load(Dog.class, new Integer(3));
        dog.setName("果果2");
        dog.setAge(3);
        session.update(dog);
        tx.commit();
        session.close();
    }
    //删除
    @Test
    public void test04() {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Dog dog = (Dog) session.load(Dog.class, new Integer(3));
        session.delete(dog);
        tx.commit();
        System.out.println(dog.getName());
        session.close();
    }
}
