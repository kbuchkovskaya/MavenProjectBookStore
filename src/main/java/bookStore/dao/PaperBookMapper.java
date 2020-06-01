package bookStore.dao;

import bookStore.dao.models.PaperBook;

import java.util.List;

public interface PaperBookMapper {

    List<PaperBook> getPaperBooks();

    PaperBook getPaperBookById(Integer id);

    void deletePaperBookById(Integer id);
}
