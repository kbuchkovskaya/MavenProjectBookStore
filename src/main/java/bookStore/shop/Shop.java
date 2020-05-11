package bookStore.shop;

import bookStore.book.Book;

/**
 * Shop class include common information about shops
 */
public abstract class Shop implements Payment {

    protected String name;
    protected Book book;

    public Shop(String name, java.awt.print.Book book) {
    }

    public Shop(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    protected Shop() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    final String bookInfo() {
        return "Information about book:";
    }

}

