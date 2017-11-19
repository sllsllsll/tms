package cn.happy.hibernate10opensessioninview.dao;


import cn.happy.hibernate10opensessioninview.util.HibernateUtil;

import java.io.Serializable;

/**
 * Created by linlin on 2017/10/9.
 */
public class HibernateDAO {

    public Object get(Class clazz, Serializable id) {
        Object result = HibernateUtil.getSession().load(clazz, id);
        return result;
    }
}