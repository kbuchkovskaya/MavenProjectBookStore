package bookStore.menu;

import bookStore.dao.models.PaperBook;
import bookStore.dao.models.Store;
import bookStore.services.PaperBookService;
import bookStore.services.StoreService;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class DBMenu {

    private final static Logger LOGGER = Logger.getLogger(DBMenu.class);

    Scanner scanner = new Scanner(System.in);

    public void getAllPaperBooks(){

        List<PaperBook> paperBooks = new PaperBookService().getAllPaperBooks();

        for (PaperBook paperBook : paperBooks){
            LOGGER.info("Id: " + paperBook.getId() + " " +
                    "Name: " + paperBook.getName() + " " +
                    "Author: " + paperBook.getAuthor() + " " +
                    "Price: " + paperBook.getPrice() + " " +
                    "Publication year: " + paperBook.getPublicationYear() + " " +
                    "Genre: " + paperBook.getGenre() + " " +
                    "Cover type: " + paperBook.getCoverType() + " " +
                    "Size: " + paperBook.getSize()
            );
        }

    }

    public void getPaperBookInfoById(){

        LOGGER.info("Choose one of the id: ");
        int id = scanner.nextInt();
        PaperBook paperBook = new PaperBookService().getPaperBookById(id);
        LOGGER.info(paperBook.getName());
    }

    public void deletePaperBook(){

        LOGGER.info("Choose one of the id: ");
        int id = scanner.nextInt();
        new PaperBookService().deletePaperBookById(id);
        LOGGER.info("Deleted successfully!");

    }

    public void getAllStores(){

        List<Store> stores = new StoreService().getAllStores();

        for (Store store : stores){
            LOGGER.info("Id: " + store.getId() + " " +
                    "Shop name: " + store.getShopName() + " " +
                    "Address: " + store.getAddress()
            );
        }
    }

    public void getStoresWithPaperBooks(){

        List<Store> stores = new StoreService().getStoresWithPaperBooks();

        for (Store store : stores){
            LOGGER.info("Id: " + store.getId() + " " +
                    "Shop name: " + store.getShopName() + " " +
                    "Address: " + store.getAddress() + " "
                  //  "Book name: " +
            );
        }

    }

    public void menu(){
        getAllPaperBooks();
        getPaperBookInfoById();
        deletePaperBook();
        getAllStores();
        getStoresWithPaperBooks();
    }

}
