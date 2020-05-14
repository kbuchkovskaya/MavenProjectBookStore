package bookStore.book;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * Storage for lists of paper book, e-book and audio book
 * and for Map
 */
public class Storage {

    public static int bookCounter;

    private Map<String, String> bookMap;
    private List<? super Book> listOfBooks;

    public Storage() {
        bookMap = new HashMap<>();
        listOfBooks = new ArrayList<>();
    }

    public List<? super Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<? super Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public void setBookMap(Map<String, String> bookMap) {
        this.bookMap = bookMap;
    }

    public Map<String, String> getBookMap() { return bookMap; }

    public void addPaperBookInfo(PaperBook paperBook) {
        this.listOfBooks.add(paperBook);
    }

    public void addEBook(EBook eBook) {
        this.listOfBooks.add(eBook);
    }

    public void addAudioBook(AudioBook audioBook) {
        this.listOfBooks.add(audioBook);
    }

    public static void increaseBookQuantity(){
        bookCounter++;
    }

    public static void decreaseBookQuantity(){ bookCounter--; }

    public void fillBookMap(String bookName, String type) {
        bookMap.put(bookName, type);
    }

    public void removeBookMap(String bookName) {
        bookMap.keySet().removeIf(key -> key.equals(bookName));
    }

    public void printBookMapInfo() {
        bookMap.forEach((nameOfBook, type) -> System.out.println("Book type: " + type + "    " + "Book name: " + nameOfBook));
    }

}


