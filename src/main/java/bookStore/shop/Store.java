package bookStore.shop;

/**
 * A <code>Store</code> object represent
 * shop type - store
 */

public final class Store extends Shop implements Payment {

    private String address;

    public Store() {

    }

    public Store(String name, bookStore.book.Book book, String address) {
        super(name, book);
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return bookInfo() + "\n" +
                "Store{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
    }

}

