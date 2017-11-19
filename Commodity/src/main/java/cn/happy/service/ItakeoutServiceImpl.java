package cn.happy.service;

import cn.happy.beans.takeout;
import cn.happy.dao.ItakeoutDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by linlin on 2017/10/19.
 */
@Transactional
@Repository("ItakeoutSevice")
public class ItakeoutServiceImpl implements ItakeoutSevice {
    @Resource(name = "ItakeoutDao")
    private ItakeoutDao dao;


    public ItakeoutDao getDao() {
        return dao;
    }

    public void setDao(ItakeoutDao dao) {
        this.dao = dao;
    }

    public int addtake(takeout to) {
        return dao.addtake(to);
    }

    public void updatetake(Integer quantity, Integer id) {
        dao.updatetake(quantity, id);
    }
}
