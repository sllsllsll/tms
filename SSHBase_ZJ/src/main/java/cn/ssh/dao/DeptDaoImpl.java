package cn.ssh.dao;

import cn.ssh.beans.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/29.
 */
@Repository("DeptDao")
public class DeptDaoImpl implements IDeptDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    public void addDept(Dept dept) {

        Session session = sessionFactory.getCurrentSession();
        session.save(dept);
    }

    public List<Dept> DeptList() {
        return sessionFactory.getCurrentSession().createQuery("from Dept").list();
    }

    public void delDept(Integer deptno) {
        sessionFactory.getCurrentSession().delete(deptno);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
