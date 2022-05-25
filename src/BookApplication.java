import java.util.List;
import java.util.Scanner;

public class BookApplication {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        List<Book> bookList = BookDatabaseManager.getAllBooks();
        List<Author> authorList = BookDatabaseManager.getAllAuthors();


        int choice;

        do {
            System.out.println("\n\nWelcome to Book Store");
            System.out.println("Navigation Menu");
            System.out.println("Enter 1 to Print all the books from the database (showing the authors)");
            System.out.println("Enter 2 to Print all the authors from the database (showing the books)");
            System.out.println("Enter 3 to Add a book to the database for an existing author ");
            System.out.println("Enter 4 to show authors Books");
            System.out.println("Enter 5 to Add a new author");
            System.out.println("Enter 6 to Quit");

            choice = input.nextInt();
            if (choice==1){
                bookList.forEach(book -> book.printBookInfo(System.out));
                System.out.println("\n Author");
                authorList.forEach(author -> author.printAuthorsInfo(System.out));
                // add author
            }
            else if(choice == 2){

                System.out.println("Enter Isbn");
                String isbn = input.next();
                BookDatabaseManager.getBookISBN(isbn).printBookInfo(System.out);
            }
            else if(choice == 3){
                System.out.println("Enter ISBN");
                String isbn1 = input.next();
                System.out.println("Enter title");
                String title = input.next();
                System.out.println("Enter edition number ");
                int number = input.nextInt();
                System.out.println("Enter year");
                String year = input.next();
                BookDatabaseManager.insertBook(new Book(isbn1,title,number,year));
                BookDatabaseManager.getBookISBN(isbn1).printBookInfo(System.out);
                System.out.println("\n"+title+" Has been added");
//                BookDatabaseManager.getBookISBN(isbn1).printBookInfo(System.out);
                bookList.forEach(book -> book.printBookInfo(System.out));

                // add the book for author in db only.

            }
            else if(choice == 4){

                authorList.forEach(author -> author.printAuthorsInfo(System.out));
            }else if(choice == 5){
                System.out.println("Enter Author ID : ");
                int id = input.nextInt();
                System.out.println("Enter Author first name :");
                String first = input.next();
                System.out.println("Enter Author last name :");
                String last = input.next();
                BookDatabaseManager.insertAuthor(new Author(id,first,last));
                System.out.println("\n"+first+" Has been added");
                authorList.forEach(author -> author.printAuthorsInfo(System.out));
                // done
            }
            else {break;}

        }while (true);
        System.out.println("See you next time Bye!");


    }
}
