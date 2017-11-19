package cn.happy.dao;

import cn.happy.beans.Dept;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by linlin on 2017/10/13.
 */
@Transactional
@Repository("deptDAO")
public class DeptDaoImpl implements IDeptDao {
    @Resource
    private SessionFactory sessionFactory;

    public int addDept(Dept dept) {
        Serializable count = sessionFactory.getCurrentSession().save(dept);
        return (Integer) count;
    }

    public List<Dept> listdept() {
        return sessionFactory.getCurrentSession().createQuery("from Dept").list();

    }

    public Dept findOne(Integer deptno) {
        Dept dept = sessionFactory.getCurrentSession().get(Dept.class, deptno);
        return dept;
    }

    public void dellist(Integer deptno) {
        Dept one = findOne(deptno);
        Session session = sessionFactory.getCurrentSession();
        session.delete(one);
    }

    public void updateDept(String deptname, Integer deptno) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Dept d set d.deptname=:ddeptname where d.deptno=:qid")
                .setParameter("ddeptname", deptname)
                .setParameter("qid", deptno)
                .executeUpdate();
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
