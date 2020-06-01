package bookStore.db;

import bookStore.book.PaperBook;
import bookStore.shop.EShop;
import bookStore.shop.Store;
import bookStore.utils.database.ValuesForDatabase;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Connector {

    private final static Logger LOGGER = Logger.getLogger(Connector.class);

    Scanner scanner = new Scanner(System.in);

    ValuesForDatabase valuesForDatabase = new ValuesForDatabase();

    public Connection connector(){

        Connection connection = null;

        try {
            Class.forName(valuesForDatabase.getDatabaseProperties("db.driver"));

            connection = DriverManager.getConnection(
                    valuesForDatabase.getDatabaseProperties("db.url"),
                    valuesForDatabase.getDatabaseProperties("db.username"),
                    valuesForDatabase.getDatabaseProperties("db.password")
            );

            LOGGER.info("Connected OK!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void selectFromPaperBook(){

        try {
            Statement statement = connector().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM paperbook"
            );
            while (resultSet.next()){
                LOGGER.info("id: " + resultSet.getInt("id"));
            }
        }
        catch (SQLException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void insertToStore(){
        try {
            Statement statement = connector().createStatement();
            statement.executeUpdate(
                    "INSERT INTO store (id, address, shopname) VALUES (1, 'address', 'shopname');"
            );
        } catch (SQLException e){
            LOGGER.error(e.getMessage());
        }
    }


    public void addPaperBookToStore(PaperBook paperBook){

        try {

            PreparedStatement preparedStatement = connector().prepareStatement(Queries.INSERT_INTO_PAPERBOOK_STORE);
            preparedStatement.setString(1, paperBook.getName());
            preparedStatement.setString(2, paperBook.getAuthor());
            preparedStatement.setFloat(3, paperBook.getPrice());
            preparedStatement.setDate(4, Date.valueOf(paperBook.getPublicationYear()));
            preparedStatement.setString(5, String.valueOf(paperBook.getGenre()));
            preparedStatement.setString(6, String.valueOf(paperBook.getSize()));
            preparedStatement.setString(7, String.valueOf(paperBook.getCover()));
            preparedStatement.setInt(8, storeId());
            preparedStatement.execute();

        } catch (SQLException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void addPaperBookToEShop(PaperBook paperBook){

        try {

            PreparedStatement preparedStatement = connector().prepareStatement(Queries.INSERT_INTO_PAPERBOOK_ESHOP);
            preparedStatement.setString(1, paperBook.getName());
            preparedStatement.setString(2, paperBook.getAuthor());
            preparedStatement.setFloat(3, paperBook.getPrice());
            preparedStatement.setDate(4, Date.valueOf(paperBook.getPublicationYear()));
            preparedStatement.setString(5, String.valueOf(paperBook.getGenre()));
            preparedStatement.setString(6, String.valueOf(paperBook.getSize()));
            preparedStatement.setString(7, String.valueOf(paperBook.getCover()));
            preparedStatement.setInt(8, eshopId());
            preparedStatement.execute();

        } catch (SQLException e){
            LOGGER.error(e.getMessage());
        }
    }

    public void addStore(Store store){

        try {

            PreparedStatement preparedStatement = connector().prepareStatement(Queries.INSERT_INTO_STORE);

            preparedStatement.setString(1, store.getAddress());
            preparedStatement.setString(2, store.getName());
            preparedStatement.execute();

        } catch (SQLException e){
            LOGGER.error(e.getMessage());
        }

    }

    public void addEShop(EShop eshop){

        try {

            PreparedStatement preparedStatement = connector().prepareStatement(Queries.INSERT_INTO_ESHOP);
            preparedStatement.setString(1, eshop.getWebSite());
            preparedStatement.setString(2, eshop.getName());
            preparedStatement.execute();

        } catch (SQLException e){
            LOGGER.error(e.getMessage());
        }

    }

    public int storeId(){

        try {
            Statement statement = connector().createStatement();
            ResultSet resultSet = statement.executeQuery(Queries.SELECT_FROM_STORE);

            while (resultSet.next()){
                LOGGER.info("Select store: " + "\n" +
                        "id: " + resultSet.getInt("id") + " " +
                        "shopname: " + resultSet.getString("shopname") + " " +
                        "address: " + resultSet.getString("address")
                );
            }
            System.out.println("Choose to wich store add book: ");

        } catch (SQLException e){
            LOGGER.error(e.getMessage());
        }
        return scanner.nextInt();
    }

    public int eshopId(){

        try {
            Statement statement = connector().createStatement();
            ResultSet resultSet = statement.executeQuery(Queries.SELECT_FROM_ESHOP);

            while (resultSet.next()){
                LOGGER.info("Select store: " + "\n" +
                        "id: " + resultSet.getInt("id") + " " +
                        "shopname: " + resultSet.getString("shopname") + " " +
                        "website: " + resultSet.getString("website")
                );
            }
            System.out.println("Choose to wich eshop add book: ");

        } catch (SQLException e){
            LOGGER.error(e.getMessage());
        }
        return scanner.nextInt();
    }

    public void listOfPaperBooksInStores(){

        try {
            Statement statement =connector().createStatement();
            ResultSet resultSet = statement.executeQuery(Queries.SELECT_PAPERBOOK_FROM_STORE);

            while (resultSet.next()){
                System.out.println("Store name: " + resultSet.getString("store.shopname"));
                System.out.println("Store address: " + resultSet.getString("store.address"));
                System.out.println("Book name: " + resultSet.getString("paperbook.name"));
                System.out.println("Book author: " + resultSet.getString("paperbook.author"));
                System.out.println("Book price: " + resultSet.getString("paperbook.price"));
            }

        } catch (SQLException e){
            LOGGER.error(e.getMessage());
        }

    }

}
