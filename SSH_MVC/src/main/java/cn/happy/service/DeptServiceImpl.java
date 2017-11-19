package cn.happy.service;

import cn.happy.beans.Dept;
import cn.happy.dao.IDeptDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/13.
 */
@Service("deptService")
public class DeptServiceImpl implements IDeptService{
    @Resource(name="deptDAO")
    private IDeptDao dao;
    @Transactional
    public int addDept(Dept dept) {
        int result=dao.addDept(dept);
        return result;
    }

//根据id查询
    public void updateDept(String deptname, Integer deptno) {
dao.updateDept(deptname,deptno);
    }


//遍历所有
    public List<Dept> listdept() {
        return dao.listdept();
    }
    //根据id查询所有
    public Dept findOne(Integer deptno) {
        return dao.findOne(deptno);
    }
    //根据id查询
    public void dellist(Integer deptno) {
          dao.dellist(deptno);
    }



    public IDeptDao getDao() {
        return dao;
    }

    public void setDao(IDeptDao dao) {
        this.dao = dao;
    }
}
