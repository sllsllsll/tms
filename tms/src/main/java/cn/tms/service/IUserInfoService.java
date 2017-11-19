package cn.tms.service;

import cn.tms.entity.Privilege;
import cn.tms.entity.Role;
import cn.tms.entity.UserInfo;
import cn.tms.util.PageUtil;

import java.util.List;

/**
 * Created by Happy on 2017-09-27.
 */
public interface IUserInfoService {
    //登录的方法
    public UserInfo isLogin(UserInfo info);
    //2.获取总记录数
    public int getTotalCount();
    //3.获取单页数据
    public PageUtil UserInfoList(int pageIndex,int pageSize);

    //4.获取带条件的总记录数
    public int getTotalCountByUserName(String userName);

    //5.模糊查询
    public PageUtil UserInfoList(int pageIndex, int pageSize, UserInfo info);


    public Integer checkUserRoleIsExist(Integer userid, Integer roleid);

    public List<Role> getRoleByUserId(Integer userid);
    public UserInfo getUserInfoById(Integer userid);

}
