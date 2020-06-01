package bookStore;

import bookStore.dao.models.PaperBook;
import bookStore.dao.models.Store;
import bookStore.menu.DBMenu;
import bookStore.services.PaperBookService;
import bookStore.services.StoreService;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class Executor {

    private final static Logger LOGGER = Logger.getLogger(Executor.class);

    public static void main(String [] args) {

        DBMenu menu = new DBMenu();
        menu.menu();

    }
}
