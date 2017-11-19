package cn.tms.dao;

import cn.tms.entity.News;
import cn.tms.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by linlin on 2017/11/6.
 */
public interface INewsDAO {
/*   public List<News> ListNews(String clumnname);*/
//显示列表
 public List<News> ListNews(String ccode);

/**
*
 * 分页
 * *
* */
   //显示角色 分页列表
   public List<News> ListNewsLimit(Map<String, Object> map);
   //3.获取总记录数
   public int getTotalCount();
   //4.获取带条件的总记录数
   public int getTotalCountByRoleName(String ccode);




    public List<News> ListNewsLike(@Param("ntitle")String ntitle, @Param("start")Integer start);

    public int addNews(News news);
    //删除新闻
    public int delNews(Integer nid);

    //根据id查询所有
    public News ByNewsId(Integer nid);

    public int updateNews(News news);

}
