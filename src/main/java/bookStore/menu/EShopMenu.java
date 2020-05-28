package bookStore.menu;

import bookStore.db.Connector;
import bookStore.shop.EShop;

import java.util.Scanner;

public class EShopMenu {

    Scanner scanner = new Scanner(System.in);

    Connector connector = new Connector();

    public void addEShop(){

        EShop eshop = new EShop();

        System.out.println("Store name: ");
        String name = scanner.next();
        eshop.setName(name);

        System.out.println("Website: ");
        String website = scanner.next();
        eshop.setWebSite(website);

        connector.addEShop(eshop);
    }

    public void deleteEShop(){


    }
}
