package demo1;

import cn.happy.hibernate0929left.Dept;
import cn.happy.hibernate0929left.Emp;
import cn.happy.hibernate0929left.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by linlin on 2017/9/29.
 */
public class Test0929 {
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
//迫切内连接
    @Test
    public void text01() {

        Query query = session.createQuery("select distinct  d from Dept d inner join fetch d.emps");
        List<Dept> list = query.list();
        for (Dept item : list) {
            System.out.println(item.getDeptname());
            for (Emp emp : item.getEmps()) {
                System.out.println(emp.getEname());
            }
            System.out.println("=======");
        }
    }
//内连接
@Test
public void text02() {

    Query query = session.createQuery("select distinct  d from Dept d inner join d.emps");
    List<Dept> list = query.list();
    for (Dept item : list) {
        System.out.println(item.getDeptname());
        for (Emp emp : item.getEmps()) {
            System.out.println(emp.getEname());
        }
        System.out.println("=======");
    }
}


    //左内连接
    @Test
    public void text03() {

        Query query = session.createQuery("from Dept left outer join fetch emp on Dept.Deptno=emp.deptno");
        List<Dept> list = query.list();
        for (Dept item : list) {
            System.out.println(item.getDeptname());
            for (Emp emp : item.getEmps()) {
                System.out.println(emp.getEname());
            }
            System.out.println("=======");
        }
    }

    @Test
    //隐式内连接
    public void testHideInnerJoin(){
        //内连接用法
        Query query = session.createQuery("from Emp e where e.dept.deptname='开发部'");
        List<Emp> list = query.list();
        for (Emp emp : list) {
            System.out.println(emp.getEname());
        }
        tx.commit();
    }
    //隐式内连接2
   /* @Test
    public void testHideInnerJoin2(){
        //内连接用法
        Query query = session.createQuery("select d from Dept d where d.deptname='开发部'");
        List<Dept> list = query.list();
        for (Dept dept : list) {
            System.out.println(dept.getDeptname());
            System.out.println(dept.getEmps().iterator().next().getEname());
        }
        tx.commit();
    }*/
//HQL批量添加
   @Test
    public void multiInsertTest(){
    String hql="insert into Dept(deptname) select d.deptname||d.deptno from Dept d where d.deptno>0";
    session.createQuery(hql).executeUpdate();
    tx.commit();

   }
//批量更新
    @Test
    public void testUpdate(){
        String hql="update Dept set deptName=:name where deptno>30";
        session.createQuery(hql).setParameter("name","财务部").executeUpdate();
        tx.commit();
    }

    //批量删除数据
    @Test
    public void testDelete(){
        String hql="delete from Dept d where d.deptno>:deptno";
        session.createQuery(hql).setParameter("deptno",30).executeUpdate();
        tx.commit();
    }

    @Test
    public void testUpdateUseJDBC(){
        Work work=new Work() {
            public void execute(Connection connection) throws SQLException {
                String sql="update Dept set deptname=? where deptno>?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, "财务部2");
                ps.setInt(2, 1);
                ps.executeUpdate();
            }
        };
        session.doWork(work);
        tx.commit();
    }

    @Test
    public void insertUser(){
        Emp emp=null;
        for(int i=0;i<10000;i++){
            emp=new Emp(i,"emp"+i);
            session.save(emp);
            if(i%30==0){
                session.flush();
                session.clear();
            }
        }


    }

    //分组查询
    @Test
    public void testorderby(){
        Query query = session.createQuery("select e.job,count(deptno) from Employee e group by e.job");
        List<Object[]> list = query.list();
        for (Object[] emp : list) {
            System.out.println(emp[0]+","+emp[1]);
        }
        tx.commit();

    }
    //统计平均工资
    @Test
    public void testavg(){


     //   Query query = session.createQuery("select e.dept.dname,avg (e.sal) from Employee e group by e.dept.dname");
        Object salary = session.createQuery("select avg(e.sal) from Employee e").uniqueResult();
        System.out.println(salary);
        tx.commit();

    }
    //统计最大值 最小值
    @Test
    public void testminmax(){
        Query query = session.createQuery("select job,min (sal),max(sal) from Employee  group by job");
        List<Object[]> list = query.list();
        for (Object[] emp : list) {
            System.out.println(emp[0]+","+emp[1]+","+emp[2]);
        }
        tx.commit();

    }
    //查询所有员工工资都小于5000元的部门
    @Test
    public void testChild1(){
        List<Dept> list = session.createQuery("from Dept2 d where 5000>all(select e.empno from d.emps e)").list();
        for (Dept dept : list) {
            System.out.println(dept.getDeptname());
        }
        tx.commit();
    }
}
