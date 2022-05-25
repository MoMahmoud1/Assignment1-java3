import java.util.List;
import java.util.Scanner;

public class BookApplication {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        List<Book> bookList = BookDatabaseManager.getAllBooks();
        List<Author> authorList = BookDatabaseManager.getAllAuthors();
<<<<<<< HEAD
        BookDatabaseManager bookDatabaseManager = new BookDatabaseManager();
=======
>>>>>>> origin/master


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
<<<<<<< HEAD
                for(Book book : bookDatabaseManager.getBookList()){
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("ISBN: " + book.getIsbn());
                    System.out.println("Edition: " + book.getAdditionNumber());
                    System.out.println("Copyright: " + book.getCopyright());
                    book.getAuthorList().forEach(author -> author.printAuthorsInfo(System.out));
                    System.out.println("\n");
                }


            }
            else if(choice == 2){
                for(Author author : bookDatabaseManager.getAuthorList()) {
                    System.out.println("Author ID: " + author.getId());
                    System.out.println("First Name: " + author.getFirstName());
                    System.out.println("Last Name: " + author.getLastName());
//                    String bookString = "";
//                    int count = 0;
//                    for (Book book : author.getBookList()) {
//                        if (author.getBookList().size() == 1){
//                            bookString += book.getTitle();
//                        }else if ((count + 1) == author.getBookList().size()) {
//                            bookString += "and " + book.getTitle();
//                        } else if (book.getAuthorList().size() == 2) {
//                            bookString += book.getTitle() + " ";
//                        } else {
//                            bookString += book.getTitle() + ", ";
//                        }
//                        count++;
//                }
//                    System.out.println("Books: " + bookString + "\n");
                }

=======
                bookList.forEach(book -> book.printBookInfo(System.out));
                System.out.println("\n Author");
                authorList.forEach(author -> author.printAuthorsInfo(System.out));
                // add author
            }
            else if(choice == 2){

                System.out.println("Enter Isbn");
                String isbn = input.next();
                BookDatabaseManager.getBookISBN(isbn).printBookInfo(System.out);
>>>>>>> origin/master
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
