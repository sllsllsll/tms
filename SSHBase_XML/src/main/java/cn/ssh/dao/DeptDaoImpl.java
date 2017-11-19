package cn.ssh.dao;

import cn.ssh.beans.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by linlin on 2017/10/29.
 */
public class DeptDaoImpl implements IDeptDao {
    private SessionFactory sessionFactory;
    public void addDept(Dept dept) {

        Session session = sessionFactory.getCurrentSession();
        session.save(dept);
    }

    public List<Dept> DeptList() {
        System.out.println("da0=======================");
        return  sessionFactory.getCurrentSession().createQuery("from Dept").list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
