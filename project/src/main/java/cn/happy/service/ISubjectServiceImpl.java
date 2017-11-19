package cn.happy.service;

import cn.happy.bean.Subjects;
import cn.happy.dao.ISubjectDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 张晓宇 on 2017/10/13.
 */
@Service("ISubjectService")
public class ISubjectServiceImpl implements ISubjectService{
    @Resource
    private ISubjectDao subjectDao;
    @Transactional
    public List<Subjects> getAllSubject() {
        return subjectDao.getAllSubject();
    }

    @Transactional
    public Subjects getView(int id) {
        return subjectDao.getView(id);
    }

    @Transactional
    public void updateCount() {
        subjectDao.updateCount();
    }

    @Transactional
    public void updateOption(int id, int sid) {
        subjectDao.updateOption(id,sid);
    }

    public ISubjectDao getSubjectDao() {
        return subjectDao;
    }

    public void setSubjectDao(ISubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }
}
