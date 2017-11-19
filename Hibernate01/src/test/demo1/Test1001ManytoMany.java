package demo1;

import cn.happy.hibernate1001manytomany.Game;
import cn.happy.hibernate1001manytomany.PlayHome;
import cn.happy.hibernate1001zujie2.Dept;
import cn.happy.hibernate1001zujie2.Emp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by linlin on 2017/9/30.
 */
public class Test1001ManytoMany {
    Configuration cfg;
    Transaction tx;
    Session session;
    SessionFactory factory;

    @Before
    public void myBefore() {
        //创建配置对象
        cfg = new Configuration().configure("Hibernate1.cfg.xml");
        //根据配置对象创建SessionFactory
        factory = cfg.buildSessionFactory();
        //根据SessionFactory创建Session
        session = factory.openSession();
        //在Session创建后开启事务
        tx = session.beginTransaction();
    }

    //注解 的 多对多
    @Test
    public void Test01add() {

     Game game=new Game();
     game.setGname("CS");
     Game game1=new Game();
     game1.setGname("c#");
        PlayHome p1=new PlayHome();
        p1.setPname("哈哈哈");

        PlayHome p2=new PlayHome();
        p2.setPname("呵呵");

        game.getPlayHomes().add(p1);
        game.getPlayHomes().add(p2);
        game1.getPlayHomes().add(p1);
        game1.getPlayHomes().add(p2);
        p1.getGame().add(game);
        p1.getGame().add(game1);
        p2.getGame().add(game);
        p2.getGame().add(game1);
        session.save(game);
        session.save(game1);
        tx.commit();

    }

   /* @Test
    public void Test01add2() {
        Dept dept = session.get(Dept.class, 10045);
        System.out.println(dept.getDname());
        System.out.println(dept.getEmps().iterator().next().getEname());
    }*/
}
