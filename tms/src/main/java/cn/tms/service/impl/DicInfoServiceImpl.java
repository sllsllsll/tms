package cn.tms.service.impl;

import cn.tms.dao.IDicInfoDAO;
import cn.tms.entity.DicInfo;
import cn.tms.service.IDicInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Happy on 2017-09-27.
 */
@org.springframework.stereotype.Service("dicService")
public class DicInfoServiceImpl implements IDicInfoService {
    @Resource(name = "IDicInfoDAO")
    IDicInfoDAO dicInfoDAO;

    public List<DicInfo> findAllTeacher() {
        return dicInfoDAO.findAllTeacher();
    }

    public List<DicInfo> findAllLab() {
        return dicInfoDAO.findAllLab();
    }
}
