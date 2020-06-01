package bookStore.services;

import bookStore.dao.PaperBookMapper;
import bookStore.dao.models.PaperBook;
import bookStore.dao.myBatisImpl.PaperBookDao;

import java.util.List;

public class PaperBookService {

    private PaperBookMapper paperBookDao = new PaperBookDao();

    public List<PaperBook> getAllPaperBooks(){
        return paperBookDao.getPaperBooks();
    }

    public PaperBook getPaperBookById(Integer id) { return paperBookDao.getPaperBookById(id); }

    public void deletePaperBookById(Integer id) { paperBookDao.deletePaperBookById(id);}

}
