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
            String SqlQuery = "SELECT * FROM titles";
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            System.out.println("ISBN \t\t\t Title");
            while (resultSet.next()){

                System.out.printf("\n%s\t\t\t %s",
                        resultSet.getString("isbn"),resultSet.getString("title"));
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

        public static final String Book_TABLE_NAME= "title";


    }
}
