package cn.happy.hibernate10opensessioninview.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by linlin on 2017/10/6.
 */
public class HibernateUtil {
        //是否为hreadLocal
        static ThreadLocal<Session> tlSession;
        static Configuration cfg;
        static SessionFactory factory;

        static {
            //创建congfig对象
            cfg = new Configuration().configure();
            //factory
            factory = cfg.buildSessionFactory();
            tlSession = new ThreadLocal<Session>();
        }

        //对外提供一个静态方法 getSession
        public static Session getSession() {
            //查看现在的线程变量中有没有session
            Session session = tlSession.get();
            if (session == null) {
                //线程中没有session
                //构建session
                session = factory.openSession();
                //放入线程变量
                tlSession.set(session);
            }
            return session;
        }

        //关闭session
        public static  void closeSession() {
            Session session = tlSession.get();
            if (session != null) {
                session.close();
                tlSession.set(null);
            }
        }


}
