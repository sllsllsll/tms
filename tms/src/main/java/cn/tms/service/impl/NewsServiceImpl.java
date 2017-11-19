package cn.tms.service.impl;

import cn.tms.dao.INewsDAO;
import cn.tms.entity.News;
import cn.tms.entity.UserInfo;
import cn.tms.service.INewsService;
import cn.tms.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linlin on 2017/11/6.
 */
@Service("newService")
public class NewsServiceImpl implements INewsService {
    @Resource(name="INewsDAO")
    private INewsDAO dao;
/*
    public List<News> ListNews(String columnname) {
        return dao.ListNews(columnname);
    }*/

    public List<News> ListNews(String ccode) {
        return dao.ListNews(ccode);
    }

    public PageUtil ListNewsLimit(String ccode, int pageIndex, int pageSize) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("ccode",ccode);
        PageUtil page=new PageUtil(); //实例化一个PageUtil对象
        page.setPageSize(pageSize); //给PageUtil属性赋值
        page.setPageIndex(pageIndex);//给PageUtil的pageIndex赋值

        page.setTotalRecords(dao.getTotalCount());
        int totalPages=page.getTotalRecords()%page.getPageSize()==0?page.getTotalRecords()/page.getPageSize():page.getTotalRecords()/page.getPageSize()+1;
        page.setTotalPages(totalPages);
        //为什么dao层方法的入参我写成map？？？
        List<News> list = dao.ListNewsLimit(map);
        page.setList(list);
        return page;
    }

    public int getTotalCount() {
        return dao.getTotalCount();
    }

    public int getTotalCountByRoleName(String ccode) {
        return dao.getTotalCountByRoleName(ccode);
    }

    public List<News> ListNewsLike(@Param("ntitle") String ntitle, @Param("start") Integer start) {
        return dao.ListNewsLike(ntitle,start);
    }

    public int addNews(News news) {
        return dao.addNews(news);
    }

    public int delNews(Integer nid) {
        return dao.delNews(nid);
    }

    public News ByNewsId(Integer nid) {

        return dao.ByNewsId(nid);
    }

    public int updateNews(News news) {
        return dao.updateNews(news);
    }


    public INewsDAO getDao() {
        return dao;
    }

    public void setDao(INewsDAO dao) {
        this.dao = dao;
    }
}
