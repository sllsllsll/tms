package cn.happy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Happy on 2017-09-25.
 * ThreadLocal 线程变量  get set
 */
public class HibernateUtil {
    private static ThreadLocal<Session> tl;
    private static Configuration cfg;
    private static SessionFactory factory;
    static {
        tl=new ThreadLocal<Session>();
        cfg=new Configuration().configure();
        factory=cfg.buildSessionFactory();
    }
    //获取和当前线程绑定的session
    public static Session getSession(){
        //尝试着从线程中看看有没有线程变量
        Session session = tl.get();
        if (session==null){
            //线程中没有session对象，创建一个
            session = factory.openSession();
            tl.set(session);
        }
        return session; //没有和当前线程绑定
    }
    public static void closeSession(){
        Session session = tl.get();
        tl.set(null);
        session.close();
    }
}
