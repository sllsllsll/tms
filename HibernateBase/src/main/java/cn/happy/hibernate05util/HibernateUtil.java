package cn.happy.hibernate05util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by linlin on 2017/10/6.
 */
public class HibernateUtil {
    static ThreadLocal<Session> t1Session;
    static Configuration cfg;
    static SessionFactory factory;
    static{
        cfg=new Configuration().configure();
        factory=cfg.buildSessionFactory();
        t1Session=new ThreadLocal<Session>();

    }
    public static Session getSession(){
        Session session=t1Session.get();
        if(session==null){
            session=factory.openSession();
            t1Session.set(session);
        }
        return session;
    }
    public void closeSession(){
        Session session=t1Session.get();
        if(session!=null){
            session.close();
            t1Session.set(null);

        }

    }
}
