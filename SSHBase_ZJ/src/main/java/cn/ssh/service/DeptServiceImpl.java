package cn.ssh.service;

import cn.ssh.beans.Dept;
import cn.ssh.dao.IDeptDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/29.
 */
@Service("DeptService")
public class DeptServiceImpl implements DeptService {
    @Resource(name="DeptDao")
    private IDeptDao deptDao;
    @Transactional
    public void addDept(Dept dept) {
        deptDao.addDept(dept);
    }

    public List<Dept> DeptList() {
        return deptDao.DeptList();
    }

    public void delDept(Integer deptno) {
        deptDao.delDept(deptno);
    }

    public IDeptDao getDeptDao() {
        return deptDao;
    }

    public void setDeptDao(IDeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
