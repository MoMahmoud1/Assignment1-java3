import java.util.List;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        List<Book> bookList = BookDatabaseManager.getAllBooks();
        bookList.forEach(book -> book.printBookInfo(System.out));



        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Book Store");
        System.out.println("Navigation Menu");
        System.out.println("Enter 1 to show all books Info ");
        System.out.println("Enter 2 to show book Info by ISBN ");
        System.out.println("Enter 3 to show authors Books");
        System.out.println("Enter 4 to Add a book to the database for an existing author ");
        System.out.println("Enter 5 to Add a new author");
        System.out.println("Enter 6 to Quit");







    }
}
