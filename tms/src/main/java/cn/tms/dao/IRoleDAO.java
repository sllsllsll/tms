package cn.tms.dao;

import cn.tms.entity.Role;
import cn.tms.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Happy on 2017-08-21.
 */
public interface IRoleDAO {
    //显示角色 分页列表
    public List<Role> RoleList(Map<String, Object> map);
    //3.获取总记录数
    public int getTotalCount();
    //4.获取带条件的总记录数
    public int getTotalCountByRoleName(String rolename);

    public List<Role> getAllRoles();
    public void AddRoleForUser(Integer userid,Integer roleid);


}
