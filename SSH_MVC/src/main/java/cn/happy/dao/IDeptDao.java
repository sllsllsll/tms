package cn.happy.dao;

import cn.happy.beans.Dept;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by linlin on 2017/10/13.
 */
public interface IDeptDao {
    //添加
    public int addDept(Dept dept);
    //遍历所有
  public List<Dept> listdept();
  //根据id获取数据
    public Dept findOne(Integer deptno);
  //删除
    public void dellist(Integer deptno);
//修改
    public void updateDept(String deptname,Integer deptno);

}
