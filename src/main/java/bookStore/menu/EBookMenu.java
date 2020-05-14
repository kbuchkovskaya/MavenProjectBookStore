package bookStore.menu;


import bookStore.book.EBook;
import bookStore.book.EBookType;
import bookStore.book.Genre;
import bookStore.book.Storage;
import org.apache.log4j.Logger;


import java.time.LocalDate;
import java.util.Scanner;

public class EBookMenu {

    private final static Logger LOGGER = Logger.getLogger(EBookMenu.class);

    private static final String E_BOOK_TYPE = "E-book";

    Scanner scanner = new Scanner(System.in);

    public void enterEBookInfo(Storage storage)  {

        EBook eBook = new EBook();

        System.out.println("Name: ");
        String eBookName = scanner.next();
        eBook.setName(eBookName);
        storage.fillBookMap(eBookName, E_BOOK_TYPE);
        LOGGER.info("Book is successfully added to map!");

        System.out.println("Author: ");
        String eAuthor = scanner.next();
        eBook.setAuthor(eAuthor);

        System.out.println("Public year (yyyy-dd-mm): ");
        String ePubYear = scanner.next();
        eBook.setPublicationYear(LocalDate.parse(ePubYear));

        System.out.println("Price: ");
        float ePrice = scanner.nextFloat();
        eBook.setPrice(ePrice);

        System.out.println("Choose one of the genre...");
        String eGenre = scanner.next();
        eBook.setGenre(Genre.valueOf(eGenre));

        System.out.println("Memory: ");
        String eMemory = String.valueOf(scanner.nextDouble());
        eBook.setMemory(Double.parseDouble(eMemory));

        System.out.println("Website: ");
        String eWebSite = scanner.next();
        eBook.setWebSite(eWebSite);

        System.out.println("E-book type: ");
        String eBookType = scanner.next();
        eBook.seteType(EBookType.valueOf(eBookType));

        storage.addEBook(eBook);
        Storage.increaseBookQuantity();
    }

    public void deleteEBook(Storage storage) {
        System.out.println("Enter book name which you want to delete: ");
        String eBookName = scanner.next();
        if (!storage.getBookMap().isEmpty()) {
            storage.removeBookMap(eBookName);
            Storage.decreaseBookQuantity();
            System.out.println("Book deleted successfully!");
        }
    }

}
