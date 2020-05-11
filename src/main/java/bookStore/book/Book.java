package bookStore.book;

import java.time.LocalDate;

/**
 * Book class include common information about book
 */
public abstract class Book {

    protected String name;
    protected String author;
    protected LocalDate publicationYear;
    protected float price;
    public Genre genre;

    public Book() {

    }

    public Book(String name, String author, LocalDate publicationYear, float price, Genre genre) {
        this.name = name;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
        this.genre = genre;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublicationYear() {
        return this.publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}

