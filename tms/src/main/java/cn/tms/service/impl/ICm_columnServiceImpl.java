package cn.tms.service.impl;


import cn.tms.dao.ICm_columnDAO;
import cn.tms.entity.cm_column;
import cn.tms.service.ICm_columnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by linlin on 2017/11/6.
 */
@Service("cm_columnservice")
public class ICm_columnServiceImpl implements ICm_columnService {

    @Resource(name="ICm_columnDAO")
    private ICm_columnDAO dao;



    public ICm_columnDAO getDao() {
        return dao;
    }

    public void setDao(ICm_columnDAO dao) {
        this.dao = dao;
    }

    public List<cm_column> CMListAll() {
        return dao.CMListAll();
    }

    public List<cm_column> CMListAll1() {
        return dao.CMListAll1();
    }

    public List<cm_column> SelectPid(String parentcode) {
        return dao.SelectPid(parentcode);
    }
}
