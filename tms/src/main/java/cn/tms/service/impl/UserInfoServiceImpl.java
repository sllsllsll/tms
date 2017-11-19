package cn.tms.service.impl;

import cn.tms.dao.IUserInfoDAO;
import cn.tms.entity.Privilege;
import cn.tms.entity.Role;
import cn.tms.entity.UserInfo;
import cn.tms.service.IUserInfoService;
import cn.tms.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2017-9-27 09:42:36
 */
@Service("useService")
public class UserInfoServiceImpl implements IUserInfoService {
    //植入dao对象
    @Resource(name = "IUserInfoDAO")
    IUserInfoDAO userInfoDAO;

    public UserInfo isLogin(UserInfo info) {
        return userInfoDAO.isLogin(info);
    }

    public int getTotalCount() {
        return userInfoDAO.getTotalCount();
    }

    public PageUtil UserInfoList(int pageIndex, int pageSize) {

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        PageUtil<UserInfo> page=new PageUtil<UserInfo>(); //实例化一个PageUtil对象
        page.setPageSize(pageSize); //给PageUtil属性赋值
        page.setPageIndex(pageIndex);//给PageUtil的pageIndex赋值

        page.setTotalRecords(userInfoDAO.getTotalCount());
        int totalPages=page.getTotalRecords()%page.getPageSize()==0?page.getTotalRecords()/page.getPageSize():page.getTotalRecords()/page.getPageSize()+1;
        page.setTotalPages(totalPages);
        //为什么dao层方法的入参我写成map？？？
        List<UserInfo> list = userInfoDAO.UserInfoList(map);
        page.setList(list);
        return page;
    }

    public int getTotalCountByUserName(String userName) {
        return userInfoDAO.getTotalCountByUserName(userName);
    }

    public PageUtil UserInfoList(int pageIndex, int pageSize, UserInfo info) {


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        if (info!=null) {
            map.put("userName", info.getUsername());
        }
        PageUtil page=new PageUtil(); //实例化一个PageUtil对象

        page.setPageSize(pageSize); //给PageUtil属性赋值
        page.setPageIndex(pageIndex);//给PageUtil的pageIndex赋值
        //
        if (info!=null){
            page.setTotalRecords(userInfoDAO.getTotalCountByUserName(info.getUsername()));
        }else{
            page.setTotalPages(userInfoDAO.getTotalCount());
        }
        int totalPages=page.getTotalRecords()%page.getPageSize()==0?page.getTotalRecords()/page.getPageSize():page.getTotalRecords()/page.getPageSize()+1;
        page.setTotalPages(totalPages);
        //为什么dao层方法的入参我写成map？？？
        List<UserInfo> list = userInfoDAO.UserInfoList(map);
        page.setList(list);
        return page;
    }

    public Integer checkUserRoleIsExist(Integer userid, Integer roleid) {
        return userInfoDAO.checkUserRoleIsExist(userid,roleid);
    }

    public List<Role> getRoleByUserId(Integer userid) {
        return userInfoDAO.getRoleByUserId(userid);
    }

    public UserInfo getUserInfoById(Integer userid) {
        return userInfoDAO.getUserInfoById(userid);
    }



    public IUserInfoDAO getUserInfoDAO() {
        return userInfoDAO;
    }

    public void setUserInfoDAO(IUserInfoDAO userInfoDAO) {
        this.userInfoDAO = userInfoDAO;
    }
}
