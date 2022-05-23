import java.util.List;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Book> bookList = BookDatabaseManager.getAllBooks();

        int choice;

        do {
            System.out.println("\n\nWelcome to Book Store");
            System.out.println("Navigation Menu");
            System.out.println("Enter 1 to show all books Info ");
            System.out.println("Enter 2 to show book Info by ISBN ");
            System.out.println("Enter 3 to show authors Books");
            System.out.println("Enter 4 to Add a book to the database for an existing author ");
            System.out.println("Enter 5 to Add a new author");
            System.out.println("Enter 6 to Quit");

            choice = input.nextInt();
            if (choice==1){
                bookList.forEach(book -> book.printBookInfo(System.out));
            }
            else if(choice == 2){
                System.out.println("Enter Isbn");
                String isbn = input.next();
                BookDatabaseManager.getBookISBN(isbn).printBookInfo(System.out);
            }
            else if(choice == 3){
                System.out.println("Enter ISBN");
                String isbn = input.next();
                System.out.println("Enter title");
                String title = input.next();
                System.out.println("Enter edition number ");
                int number = input.nextInt();
                System.out.println("Enter year");
                String year = input.next();
                BookDatabaseManager.insertBook(new Book("",title,number,year));
                BookDatabaseManager.getBookISBN(isbn).printBookInfo(System.out);
            }


            else {break;}

        }while (true);
        System.out.println("See you next time Bye!");


    }
}
