package cn.tms.service;

import cn.tms.entity.News;
import cn.tms.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by linlin on 2017/11/6.
 */
public interface INewsService {
/*   public List<News> ListNews(String columnname);*/
public List<News> ListNews(String ccode);

    /**
     *
     * @param ntitle
     * @param start
     * @return
     */

    //显示角色 分页列表
    public PageUtil ListNewsLimit(String ccode,int pageIndex, int pageSize);
    //3.获取总记录数
    public int getTotalCount();
    //4.获取带条件的总记录数
    public int getTotalCountByRoleName(String ccode);






    public List<News> ListNewsLike(@Param("ntitle")String ntitle, @Param("start")Integer start);
    public int addNews(News news);
    public int delNews(Integer nid);

    //根据id查询所有
    public News ByNewsId(Integer nid);

    public int updateNews(News news);
}
