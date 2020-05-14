package bookStore.menu;

import bookStore.book.*;

import org.apache.log4j.Logger;


import java.time.LocalDate;
import java.util.Scanner;

public class PaperBookMenu {

    private final static Logger LOGGER = Logger.getLogger(PaperBookMenu.class);

    public static final String PAPER_BOOK_TYPE = "Paper book";

    Scanner scanner = new Scanner(System.in);

    public void enterPaperBookInfo(Storage storage)  {

        PaperBook paperBook = new PaperBook();

        System.out.println("Name: ");
        String ppName = scanner.next();
        paperBook.setName(ppName);
        storage.fillBookMap(ppName, PAPER_BOOK_TYPE);
        LOGGER.info("Book is successfully added to map!");

        System.out.println("Author: ");
        String ppAuthor = scanner.next();
        paperBook.setAuthor(ppAuthor);

        System.out.println("Public year (yyyy-dd-mm): ");
        String ppPubYear = scanner.next();
        paperBook.setPublicationYear(LocalDate.parse(ppPubYear));

        System.out.println("Price: ");
        float ppPrice = scanner.nextFloat();
        paperBook.setPrice(ppPrice);

        System.out.println("Choose one of the genre...");
        String ppGenre = scanner.next();
        paperBook.setGenre(Genre.valueOf(ppGenre));

        System.out.println("Choose one of the cover type...");
        String ppCoverType = scanner.next();
        paperBook.setCover(CoverType.valueOf(ppCoverType));

        System.out.println("Choose one of the size...");
        String ppSize = scanner.next();
        paperBook.setSize(Size.valueOf(ppSize));

        storage.addPaperBookInfo(paperBook);
        Storage.increaseBookQuantity();

    }

    public void deletePaperBook(Storage storage) {
        System.out.println("Enter book name which you want to delete: ");
        String bookName = scanner.next();
        if (!storage.getBookMap().isEmpty()) {
            storage.removeBookMap(bookName);
            Storage.decreaseBookQuantity();
            System.out.println("Book deleted successfully!");
        }
    }

}
