package bookStore.book;

import org.apache.log4j.Logger;

import java.time.LocalDate;

/**
 * An <code>PaperBook</code> object represent
 * book subtype - paper books
 */

public class PaperBook extends Book {

    private final static Logger LOGGER = Logger.getLogger(AudioBook.class);

    private CoverType cover;
    private Size size;

    public PaperBook() {

    }

    public PaperBook(String name, String author, LocalDate publicationYear, float price, Genre genre, CoverType cover, Size size) {
        super(name, author, publicationYear, price, genre);
        this.cover = cover;
        this.size = size;
    }

    public CoverType getCover() {
        return this.cover;
    }

    public void setCover(CoverType cover) {
        this.cover = cover;
    }

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void soldBooks(String bookPlural) {
        LOGGER.info("Sold " + bookPlural);
        System.out.print("Sold " + bookPlural + ": ");
    }

    public void soldBooks(int soldBooksQuantity) {
        System.out.println(soldBooksQuantity);
    }

}
