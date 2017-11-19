package cn.happy.dao;

import cn.happy.bean.Subjects;

import java.util.List;

/**
 * Created by 张晓宇 on 2017/10/13.
 */
public interface ISubjectDao {

    //显式列表
    public List<Subjects> getAllSubject();
    //视图
    public Subjects getView(int id);
    //修改次数
    public void  updateCount();

    public void updateOption(int id, int sid);
}
