package cn.ssh.service;

import cn.ssh.beans.Dept;
import cn.ssh.dao.IDeptDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by linlin on 2017/10/29.
 */
public class DeptServiceImpl implements DeptService {

    private IDeptDao deptDao;
    @Transactional
    public void addDept(Dept dept) {

        deptDao.addDept(dept);
    }

    public List<Dept> DeptList() {
        System.out.println("=========service");
        return deptDao.DeptList();
    }

    public IDeptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(IDeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
