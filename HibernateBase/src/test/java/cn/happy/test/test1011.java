package cn.happy.test;


import cn.happy.hibernate15onetomany.Dept;
import cn.happy.hibernate14onetoone.Card;
import cn.happy.hibernate14onetoone.Humen;
import cn.happy.hibernate15onetomany.Emp;
import cn.happy.hibernate16manytomany.Game;
import cn.happy.hibernate16manytomany.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * Created by linlin on 2017/9/22.
 */
public class test1011 {
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
    public void Test01() {
        cn.happy.hibernate13zj.Dept dept = new cn.happy.hibernate13zj.Dept();
        dept.setDeptname("开发部99");
        session.save(dept);
        tx.commit();
        System.out.println("ok");
    }


//一对一
    @Test
    public void Test02() {
        Humen h=new Humen();
        h.setHname("苏苏3");
        Card c=new Card();
        c.setCname("身份证");
        c.setHumen(h);

        session.save(c);
        session.save(h);
        tx.commit();
    }

    //一对多
    @Test
    public void Test03() {
        Dept d=new Dept();
        d.setDeptname("人事部");
        Emp e=new Emp();
        e.setEname("呵呵");
        d.getEmps().add(e);
        e.setDept(d);
        session.save(d);
        tx.commit();

    }
    //多对多
    @Test
    public void Test04() {
        Game game1=new Game();
        game1.setGname("吃糖果1");
        Game game2=new Game();
        game2.setGname("打豆豆1");

        Player player1=new Player();
        player1.setPname("呵呵1");
        Player player2=new Player();
        player2.setPname("啦啦1");

        game1.getPlayer().add(player1);
        game1.getPlayer().add(player2);
        game2.getPlayer().add(player1);
        game2.getPlayer().add(player2);

        session.save(game1);
        session.save(game2);
        tx.commit();
    }
}

