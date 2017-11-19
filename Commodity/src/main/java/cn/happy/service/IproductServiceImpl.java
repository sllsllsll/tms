package cn.happy.service;

        import cn.happy.beans.product;
        import cn.happy.dao.IproductDao;
        import org.springframework.stereotype.Repository;
        import org.springframework.transaction.annotation.Transactional;

        import javax.annotation.Resource;
        import java.util.List;

/**
 * Created by linlin on 2017/10/19.
 */
@Transactional
@Repository("IproductService")
public class IproductServiceImpl implements IproductService{
    @Resource(name="IproductDao")
    private IproductDao dao;
    public List<product> productList() {
        return dao.productList();
    }

    public IproductDao getDao() {
        return dao;
    }

    public void setDao(IproductDao dao) {
        this.dao = dao;
    }
}
