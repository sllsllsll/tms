package cn.happy.service;

import cn.happy.beans.itemtypes;
import cn.happy.beans.peitems;
import cn.happy.dao.IpeitemsDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/10/18.
 */
@Transactional
@Repository("IpeitemsService")
public class IpeitemsServiceImpl implements IpeitemsService {

    @Resource(name = "IpeitemsDao")
    private IpeitemsDao dao;

    public List<peitems> selectName() {
        return dao.selectName();
    }

    public List<peitems> peiList(Integer typeid) {
        return dao.peiList(typeid);
    }

    public List<peitems> peiList(String typename) {
        return dao.peiList(typename);
    }

    public peitems findOne(Integer itemid) {
        return dao.findOne(itemid);
    }


    public void updateDept(String itemname, Integer typeid, Integer necessary, String ref, Integer price, String info, Integer itemid) {
        System.out.println(itemname);
        dao.updateDept(itemname, typeid, necessary, ref, price, info, itemid);
    }

    public IpeitemsDao getDao() {
        return dao;
    }

    public void setDao(IpeitemsDao dao) {
        this.dao = dao;
    }

}
