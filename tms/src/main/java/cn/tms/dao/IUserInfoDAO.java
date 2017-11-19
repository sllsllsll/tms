package cn.tms.dao;

import cn.tms.entity.Privilege;
import cn.tms.entity.Role;
import cn.tms.entity.UserInfo;

import javax.xml.registry.infomodel.User;
import java.util.List;
import java.util.Map;

/**
 * Created by Happy on 2017-08-21.
 */
public interface IUserInfoDAO {
    //登录的方法
    public UserInfo isLogin(UserInfo info);
    //2. 用户列表 分页  获取单页数据带条件
    public List<UserInfo> UserInfoList(Map<String,Object> map);
    //3.获取总记录数
    public int getTotalCount();
    //4.获取带条件的总记录数
    public int getTotalCountByUserName(String username);
    //角色  。。。
    public Integer checkUserRoleIsExist(Integer userid, Integer roleid);

    public List<Role> getRoleByUserId(Integer userid);
    public UserInfo getUserInfoById(Integer userid);

}
