package cn.ssh.dao;
import cn.ssh.beans.Dept;

import java.util.List;

/**
 * Created by linlin on 2017/10/13.
 */
public interface IDeptDao {
  public void addDept(Dept dept);
  //集合遍历
  public List<Dept> DeptList();

}
