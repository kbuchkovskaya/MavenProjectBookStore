package bookStore.dao.myBatisImpl;

import bookStore.dao.PaperBookMapper;
import bookStore.dao.models.PaperBook;
import bookStore.utils.database.MyBatisConfigUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PaperBookDao implements PaperBookMapper {

    private PaperBookMapper entityDao;

    private Class<PaperBookMapper> DAOClass = PaperBookMapper.class;

    @Override
    public List<PaperBook> getPaperBooks() {
        SqlSession sqlSession = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDao = sqlSession.getMapper(DAOClass);
        List<PaperBook> entities = entityDao.getPaperBooks();
        sqlSession.close();
        return entities;
    }

    @Override
    public PaperBook getPaperBookById(Integer id) {
        SqlSession sqlSession = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDao = sqlSession.getMapper(DAOClass);
        PaperBook entity = entityDao.getPaperBookById(id);
        sqlSession.close();
        return entity;
    }

    @Override
    public void deletePaperBookById(Integer id) {
        SqlSession sqlSession = MyBatisConfigUtil.getSqlSessionFactory().openSession();
        entityDao = sqlSession.getMapper(DAOClass);
        entityDao.deletePaperBookById(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
