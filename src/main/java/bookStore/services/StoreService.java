package bookStore.services;

import bookStore.dao.StoreMapper;
import bookStore.dao.models.Store;
import bookStore.dao.myBatisImpl.StoreDao;

import java.util.List;

public class StoreService {

    private StoreMapper store = new StoreDao();

    public List<Store> getAllStores() { return store.getAllStores(); }

    public List<Store> getStoresWithPaperBooks() {
        return store.storesWithPaperBooks();
    }
}
