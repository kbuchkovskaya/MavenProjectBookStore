package bookStore.dao.myBatisImpl;

import bookStore.dao.StoreMapper;
import bookStore.dao.models.Store;
import bookStore.utils.database.MyBatisConfigUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StoreDao implements StoreMapper {

    private StoreMapper entityDao;

    private Class<StoreMapper> daoClass = StoreMapper.class;

    @Override
    public List<Store> getAllStores() {
        SqlSession sqlSession = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDao = sqlSession.getMapper(daoClass);
        List<Store> entities = entityDao.getAllStores();
        sqlSession.close();
        return entities;
    }

    @Override
    public List<Store> storesWithPaperBooks() {
        SqlSession sqlSession = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDao = sqlSession.getMapper(daoClass);
        List<Store> entities = entityDao.storesWithPaperBooks();
        sqlSession.close();
        return entities;
    }
}
