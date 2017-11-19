package cn.happy.service;

import cn.happy.beans.itemtypes;
import cn.happy.dao.IitemtypesDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/18.
 */
@Transactional
@Repository("IitemtypesService")
public class IitemtypesServiceImpl implements IitemtypesService{
    @Resource(name="IitemtypesDao")
    private IitemtypesDao dao;
    public List<itemtypes> selectitem() {
        return dao.selectitem();
    }

    public IitemtypesDao getDao() {
        return dao;
    }

    public void setDao(IitemtypesDao dao) {
        this.dao = dao;
    }
}
