package bookStore;

import bookStore.db.Connector;
import bookStore.menu.MainMenu;

import java.io.IOException;

public class Executor {

    public static void main(String [] args) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.menu();
    }
}
