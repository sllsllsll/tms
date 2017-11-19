package cn.tms.service;

import cn.tms.entity.Role;
import cn.tms.entity.UserInfo;
import cn.tms.util.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by Happy on 2017-08-21.
 */
public interface IRoleService {

    //显示角色 分页列表
    public PageUtil RoleList(int pageIndex, int pageSize);
    //3.获取总记录数
    public int getTotalCount();
    //4.获取带条件的总记录数
    public int getTotalCountByRoleName(String rolename);


    //5.模糊查询
    public PageUtil getOnePageData(int pageIndex, int pageSize, UserInfo info);

    public List<Role> getAllRoles();
    public void AddRoleForUser(Integer userid,Integer roleid);

}
