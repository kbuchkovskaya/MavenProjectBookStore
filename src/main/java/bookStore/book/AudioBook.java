package bookStore.book;

import org.apache.log4j.Logger;

import java.time.LocalDate;

/**
 * An <code>AudioBook</code> object represent
 * book subtype - audio books
 */
public class AudioBook extends Book implements Price {

    private final static Logger LOGGER = Logger.getLogger(AudioBook.class);

    /**
     * Discount for all audio books
     */
    final int DISCOUNT_AUDIO_BOOK = 10;

    private BookLanguage language;
    private double memory;

    public AudioBook() {

    }

    public AudioBook(String name, String author, LocalDate publicationYear, float price, Genre genre, BookLanguage language, double memory) {
        super(name, author, publicationYear, price, genre);
        this.language = language;
        this.memory = memory;
    }

    public BookLanguage getLanguage() {
        return this.language;
    }

    public void setLanguage(BookLanguage language) {
        this.language = language;
    }

    public double getMemory() {
        return this.memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    /**
     * Count audio book price
     *
     * @return price with discount
     */
    @Override
    public float priceWithDiscount(float priceWithoutDiscount) {
        priceWithoutDiscount = (float) (price - (price * DISCOUNT_AUDIO_BOOK * 0.01));
        return priceWithoutDiscount;
    }
}
