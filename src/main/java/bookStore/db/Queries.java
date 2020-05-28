package bookStore.db;

public interface Queries {

    String INSERT_INTO_PAPERBOOK_STORE = "INSERT INTO paperbook (name, author, price, publicationyear, genre, size, covertype, storeid)" +
            "VALUES (?,?,?,?, ?::genre, ?::size, ?::covertype, ?);";

    String INSERT_INTO_PAPERBOOK_ESHOP = "INSERT INTO paperbook (name, author, price, publicationyear, genre, size, covertype, eshopid)" +
            "VALUES (?,?,?,?, ?::genre, ?::size, ?::covertype, ?);";

    String INSERT_INTO_STORE = "INSERT INTO store (shopname, address)" +
            "VALUES (?, ?);";

    String INSERT_INTO_ESHOP = "INSERT INTO eshop (shopname, website)" +
            "VALUES (?, ?);";

    String SELECT_FROM_STORE = "SELECT * FROM store;";

    String SELECT_FROM_ESHOP = "SELECT * FROM eshop;";

    String SELECT_PAPERBOOK_FROM_STORE = "SELECT store.shopname, store.address, paperbook.name, paperbook.author, paperbook.price FROM paperbook" +
            "INNER JOIN store ON paperbook.storeid=store.id;";
}
