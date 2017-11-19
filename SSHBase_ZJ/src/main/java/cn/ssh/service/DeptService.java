package cn.ssh.service;
import cn.ssh.beans.Dept;

import java.util.List;

/**
 * Created by linlin on 2017/10/13.
 */
public interface DeptService {
  public void addDept(Dept dept);
  //集合遍历
  public List<Dept> DeptList();
  //删除
  public void delDept(Integer deptno);
}
