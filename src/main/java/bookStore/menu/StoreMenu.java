package bookStore.menu;

import bookStore.db.Connector;
import bookStore.shop.Store;

import java.util.Scanner;

public class StoreMenu {

    Scanner scanner = new Scanner(System.in);

    Connector connector = new Connector();

    public void addStore(){

        Store store = new Store();

        System.out.println("Store name: ");
        String name = scanner.next();
        store.setName(name);

        System.out.println("Address: ");
        String address = scanner.next();
        store.setAddress(address);

        connector.addStore(store);

    }

    public void deleteStore(){

        System.out.println("Enter name of store which you want to delete: ");
        String store = scanner.next();

    }

    public void listOfStore(){

        System.out.println("List of books in stores: ");
        connector.listOfPaperBooksInStores();

    }


}
