package bookStore.menu;

import bookStore.book.Storage;
import bookStore.exeption.MenuExeption;
import bookStore.utils.file.RWFromFile;
import bookStore.utils.file.RWFromProperties;
import bookStore.utils.json.JsonParser;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    private final static Logger LOGGER = Logger.getLogger(MainMenu.class);

    Scanner scanner = new Scanner(System.in);

    PaperBookMenu paperBookMenu = new PaperBookMenu();
    EBookMenu eBookMenu = new EBookMenu();
    AudioBookMenu audioBookMenu = new AudioBookMenu();

    StoreMenu storeMenu = new StoreMenu();
    EShopMenu eShopMenu = new EShopMenu();

    Storage storage = new Storage();

    RWFromFile rwFromFile = new RWFromFile();
    RWFromProperties rwFromProperties = new RWFromProperties();

    JsonParser jsonParser = new JsonParser();

    public void addBook(){
        System.out.println("Which book do you want to add? 1 - Paper book; 2 - E-book; 3 - Audio book; 4 - Exit: ");
        int choiseAddBook = scanner.nextInt();
        try {
            do{
                switch (choiseAddBook){
                    case 1:
                        paperBookMenu.enterPaperBookInfo(this.storage);
                        break;
                    case 2:
                        eBookMenu.enterEBookInfo(this.storage);
                        break;
                    case 3:
                        audioBookMenu.enterAudioBookInfo(this.storage);
                        break;
                    default:
                        break;
                }
                LOGGER.debug(storage.getBookMap());
                System.out.println("Which book do you want to add? 1 - Paper book; 2 - E-book; 3 - Audio book; 4 - Exit: ");
                choiseAddBook = scanner.nextInt();
            } while (choiseAddBook == 1 || choiseAddBook == 2 || choiseAddBook == 3);
            throw new MenuExeption();
        } catch (MenuExeption e) {
            LOGGER.info("Info message: " + e.getMessage());
        } catch (InputMismatchException e){
            LOGGER.error("Error message: " + e.getMessage());
        }
    }

    public void deleteBook(){
        System.out.println("Which book do you want to delete? 1 - Paper book; 2 - E-book; 3 - Audio book; 4 - Exit: ");
        int choiseDeleteBook = scanner.nextInt();
        try {
            do {
                switch (choiseDeleteBook) {
                    case 1:
                        paperBookMenu.deletePaperBook(this.storage);
                        break;
                    case 2:
                        eBookMenu.deleteEBook(this.storage);
                        break;
                    case 3:
                        audioBookMenu.deleteAudioBook(this.storage);
                        break;
                    default:
                        break;
                }
                LOGGER.debug(storage.getBookMap());
                System.out.println("Which book do you want to delete? 1 - Paper book; 2 - E-book; 3 - Audio book; 4 - Exit: ");
                choiseDeleteBook = scanner.nextInt();
            } while (choiseDeleteBook == 1 || choiseDeleteBook == 2 || choiseDeleteBook == 3);
            throw new MenuExeption();
        } catch (MenuExeption e) {
            LOGGER.info("Info message: " + e.getMessage());
        } catch (InputMismatchException e){
            LOGGER.error("Error message: " + e.getMessage());
        }
    }

    public void booksInfo() {

        //IPaperBookMapper IPaperBookMapper =  new PaperBook();

/*        try {
            if (!storage.getBookMap().isEmpty()){
                System.out.println("List: ");
                storage.printBookMapInfo();
                System.out.println("================================");
                System.out.println("Available books: " + Storage.bookCounter);
            } else throw new EmptyListExeption();
        } catch (EmptyListExeption e){
            LOGGER.info("Info message: " + e.getMessage());
        }*/

/*        System.out.println("Reading from file: ");
        String path = rwFromProperties.getPath();
        LOGGER.info("File is opened!");
        rwFromFile.writingToFile(path, storage.getBookMap());
        rwFromFile.readFromFile(path);
        LOGGER.info("File is closed!");
        rwFromProperties.setDate();
        LOGGER.info("Last changes time is added to Date.txt!");

        String jsonStr = jsonParser.convertJavaToJsonStr(storage.getBookMap());
        LOGGER.info("JSON: " + jsonStr);
        jsonParser.convertJavaToJsonFile(storage.getBookMap(), JsonPath.PATH_JAVA_TO_JSON_FILE);
        PaperBook paperBook = jsonParser.convertJsonStrToPaperBookPOJO(JsonExample.JSON_EXAMPLE);
        LOGGER.info("Book name POJO: " + paperBook.getName());
        jsonParser.convertJsonFileToJava(JsonPath.PATH_JSON_FILE_TO_JAVA);
        jsonParser.convertJsonFileToList(JsonPath.PATH_JSON_FILE_TO_LIST);*/
    }

    public void addShop(){
        System.out.println("Which shop do you want to add: 1 - EShop; 2 - Store; 3 - Exit: ");
        int choiseShop = scanner.nextInt();
        do {
            switch (choiseShop){
                case 1:
                    eShopMenu.addEShop();
                    break;
                case 2:
                    storeMenu.addStore();
                    break;
                default:
                    break;
            }
            System.out.println("Which shop do you want to add: 1 - EShop; 2 - Store; 3 - Exit: ");
            choiseShop = scanner.nextInt();
        }
        while (choiseShop == 1 || choiseShop == 2);
    }

    public void shopMenu(){
        System.out.println("What do you wand to do? 1 - Add shop; 2 - Delete shop; 3 - Shops list; 4 - Exit: ");
        int choise = scanner.nextInt();
        do {
            switch (choise){
                case 1:
                    addShop();
                    break;
                case 2:
                    break;
                case 3:
                    storeMenu.listOfStore();
                    break;
                default:
                    break;
            }
            System.out.println("What do you wand to do? 1 - Add shop; 2 - Delete shop; 3 - Shops list; 4 - Exit: ");
            choise = scanner.nextInt();
        } while (choise == 1 || choise == 2);
    }

    public void bookMenu() {
        System.out.println("What do you wand to do? 1 - Add book; 2- Delete book; 3 - Books list; 4 - Exit: ");
        int choise = scanner.nextInt();
        do {
            switch (choise) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    booksInfo();
                    break;
                case 4:
                    break;
                default:
                    break;
            }
            System.out.println("What do you wand to do? 1 - Add book; 2- Delete book; 3 - Books list; 4 - Exit: ");
            choise = scanner.nextInt();
        } while (choise == 1 || choise == 2 || choise == 3);
    }

    public void menu(){
        System.out.println("Work with: 1 - Shops; 2 - Books; 3 - Exit:");
        int choise = scanner.nextInt();
        do {
            switch (choise){
                case 1:
                    shopMenu();
                    break;
                case 2:
                    bookMenu();
                case 3:
                    LOGGER.info("Project exit ");
                    System.exit(0);
                default:
                    break;
            }
            System.out.println("Work with: 1 - Shops; 2 - Books; 3 - Exit:");
            choise = scanner.nextInt();
        } while (choise == 1 || choise == 2);
    }

}

