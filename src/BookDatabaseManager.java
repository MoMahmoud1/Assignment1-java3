import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BookDatabaseManager {

    public BookDatabaseManager(){
        String test = BookDatabaseSQL.Book_TABLE_NAME;
    }


    public static void databaseInfo(){
        LinkedList<Book> bookList = new LinkedList<>();









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

    public static List<Author> getAllAuthors(){
        LinkedList authorList = new LinkedList();
        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
        ){
            String SqlQuery = "SELECT * FROM "+AuthorDatabaseSQL.AUTHORS_TABLE_AUTHOR_NAME;
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next()) {
                authorList.add(new Author(resultSet.getInt(AuthorDatabaseSQL.AUTHOR_COL_NAME_ID),
                        resultSet.getString(AuthorDatabaseSQL.AUTHOR_COL_NAME_FIRSTNAME),
                        resultSet.getString(AuthorDatabaseSQL.AUTHOR_COL_NAME_LASTNAME)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorList;
    }




    public static Book getBookISBN(String isbn){

        try (
                Connection connection = getConnection();

        ){
            String SqlQuery = "SELECT * FROM "+BookDatabaseSQL.Book_TABLE_NAME +
                    " where "+BookDatabaseSQL.Book_COL_NAME_ISBN+" =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.setString(1,isbn);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                 return new Book(
                         resultSet.getString(BookDatabaseSQL.Book_COL_NAME_ISBN),
                         resultSet.getString(BookDatabaseSQL.Book_COL_NAME_TITLE),
                         resultSet.getInt(BookDatabaseSQL.Book_COL_NAME_EDITION_NUMBER),
                         resultSet.getString(BookDatabaseSQL.Book_COL_NAME_COPYRIGHT)
                 );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertBook( Book book){

        try ( Connection connection =getConnection();

        ){

            String sqlQuery = "INSERT into "+ BookDatabaseSQL.Book_TABLE_NAME +
                    " Values (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setInt(3,book.getAdditionNumber());
            preparedStatement.setString(4, book.getCopyright());
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertAuthor(Author author){

        try ( Connection connection =getConnection();

        ){

            String sqlQuery = "INSERT into "+ AuthorDatabaseSQL.AUTHORS_TABLE_AUTHOR_NAME +
                    " Values (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,author.getId());
            preparedStatement.setString(2, author.getFirstName());
            preparedStatement.setString(3, author.getLastName());
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    private class AuthorDatabaseSQL{
        public static final String AUTHORS_TABLE_AUTHOR_NAME= "authors";
        public static final String AUTHOR_COL_NAME_ID= "authorID";
        public static final String AUTHOR_COL_NAME_FIRSTNAME= "firstName";
        public static final String AUTHOR_COL_NAME_LASTNAME= "lastName";




    }
}
