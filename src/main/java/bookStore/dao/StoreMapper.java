package bookStore.dao;

import bookStore.dao.models.Store;

import java.util.List;

public interface StoreMapper {

    List<Store> getAllStores();

    List<Store> storesWithPaperBooks();
}
