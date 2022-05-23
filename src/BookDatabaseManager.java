import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookDatabaseManager {

    public BookDatabaseManager(){
        String test = BookDatabaseSQL.Book_TABLE_NAME;
    }

    public static List<Book> getAllBooks(){
        LinkedList bookList = new LinkedList();
        try (
            Connection connection = getConnection();
             Statement statement = connection.createStatement();
         ){
            String SqlQuery = "SELECT * FROM "+BookDatabaseSQL.Book_TABLE_NAME;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next()) {
                bookList.add(new Book(resultSet.getString(BookDatabaseSQL.Book_COL_NAME_ISBN),
                        resultSet.getString(BookDatabaseSQL.Book_COL_NAME_TITLE),
                        resultSet.getInt(BookDatabaseSQL.Book_COL_NAME_EDITION_NUMBER),
                        resultSet.getString(BookDatabaseSQL.Book_COL_NAME_COPYRIGHT)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public static List<Book> getBookISBN(String isbn){
        LinkedList bookList = new LinkedList();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
        ){
            String SqlQuery = "SELECT * FROM "+BookDatabaseSQL.Book_TABLE_NAME;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next()) {
                bookList.add(new Book(resultSet.getString(BookDatabaseSQL.Book_COL_NAME_ISBN),
                        resultSet.getString(BookDatabaseSQL.Book_COL_NAME_TITLE),
                        resultSet.getInt(BookDatabaseSQL.Book_COL_NAME_EDITION_NUMBER),
                        resultSet.getString(BookDatabaseSQL.Book_COL_NAME_COPYRIGHT)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }



    public static boolean insertBook(){
        boolean insertSuccess = true;
        return insertSuccess;
    }


    private static Connection getConnection() throws SQLException{
           return DriverManager.getConnection(BookDatabaseSQL.DB_URL,BookDatabaseSQL.USER,BookDatabaseSQL.PASS);
    }

    private class BookDatabaseSQL{
        public static final String DB_URL= "jdbc:mariadb://localhost:3307/books";
        public static final String USER= "root";
        public static final String PASS= "Mohamed@12345";

        public static final String Book_TABLE_NAME= "titles";
        public static final String Book_COL_NAME_ISBN= "isbn";
        public static final String Book_COL_NAME_TITLE= "title";
        public static final String Book_COL_NAME_EDITION_NUMBER= "editionNumber";
        public static final String Book_COL_NAME_COPYRIGHT= "copyright";
    }
}
