package demo1;


import cn.happy.hibernate0701duoduiyi.Dept;
import cn.happy.hql.News;
import cn.happy.hqldy.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by linlin on 2017/9/24.
 */
public class hqlTest {

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


    @After
    public void myafter() {
        tx.commit();
        // session.close();
    }


    @Test
    public void test0123456() {
//检索所有新闻
        News news = new News();
        news.setNid(4);
        String hql = "from News where nid=:nid";
        Query query = session.createQuery(hql);
        //给占位符赋值
        query.setProperties(news);
        List<News> list = query.list();
        for (News item : list) {
            System.out.println(item.getNtitle());
        }
    }

    @Test
    public void addtestdy() {
//检索所有新闻
        Emp emp = new Emp();
        emp.setEmpno(111L);
        emp.setEnmae("jack");
        emp.setHiredate(new Date());
        emp.setJob("salesman");
        emp.setMgr(7698L);
        emp.setSal(1000L);
        session.save(emp);
    }

    //多条件查询
    @Test
    public void test01dong() {

        Emp emp = new Emp();
        emp.setJob("CLERK");
        emp.setSal(1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date frd = null;
        Date frd2 = null;
        try {
            frd = sdf.parse("1981-04-01");
            frd2 = sdf.parse("1985-09-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        emp.setHiredateStart(frd);
        emp.setHiredateEnd(frd2);
        String hql = "from Emp where 1=1";
        StringBuffer sb = new StringBuffer(hql);
        if (emp.getJob() != null) {
            sb.append(" and job=:job");
        }
        if (emp.getSal() != null) {
            sb.append(" and sal>:sal");
        }
        if (emp.getHiredateStart() != null) {
            sb.append(" and hiredate>=:hiredateStart");
        }
        if (emp.getHiredateEnd() != null) {
            sb.append(" and hiredate<=:hiredateEnd");
        }

        Query query = session.createQuery(sb.toString());
        //给占位符赋值
        query.setProperties(emp);
        List<Emp> list = query.list();
        for (Emp item : list) {
            System.out.println(item.getJob());
        }
    }
//分页
    @Test
    public void getPage() {
        String hql = "from Emp";
        Query query = session.createQuery(hql);
        int pageIndex = 2;
        int pagesize = 3;
        query.setFirstResult(3);
        query.setMaxResults(3);
        query.list();
        List<Emp> list = query.list();
        for (Emp item : list) {
            System.out.println(item.getJob());
        }

    }


}
