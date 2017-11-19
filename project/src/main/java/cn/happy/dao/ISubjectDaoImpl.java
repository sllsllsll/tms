package cn.happy.dao;

import cn.happy.bean.Subjects;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 张晓宇 on 2017/10/13.
 */
@Repository("ISubjectDao")
public class ISubjectDaoImpl implements ISubjectDao{
    @Resource
    private SessionFactory sessionFactory;

    public List<Subjects> getAllSubject() {
        /*Session session = sessionFactory.getCurrentSession();
        String sql=" from Subjects";
        List<Subjects> list = session.createQuery(sql).list();
        return list;*/
        return sessionFactory.getCurrentSession().createQuery("from Subjects").list();
    }

    public Subjects getView(int id) {
        Session session = sessionFactory.getCurrentSession();
        String sql="from Subjects sub where sub.id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id",id);
        return (Subjects) query.uniqueResult();
    }

    //??????????
    public void updateCount() {
      /*  Session session = sessionFactory.getCurrentSession();
        String sql="update Subjects set viewtimes=viewtimes+1 where id=1";
        Query query = session.createQuery(sql);*/
        final String sql="UPDATE subjects SET viewTimes=viewTimes+1 WHERE id=1";
        Session session = sessionFactory.getCurrentSession();
        session.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                PreparedStatement ps=connection.prepareStatement(sql);
                ps.executeUpdate();
            }
        });
    }

    public void updateOption(int id, int sid) {
        Session session = sessionFactory.getCurrentSession();
    }
}
