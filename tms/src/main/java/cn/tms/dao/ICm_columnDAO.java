package cn.tms.dao;

        import cn.tms.entity.cm_column;

        import java.util.List;

/**
 * Created by linlin on 2017/11/6.
 */
public interface ICm_columnDAO {
    public List<cm_column> CMListAll();
    public List<cm_column> CMListAll1();
    public List<cm_column> SelectPid(String parentcode);

}