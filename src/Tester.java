import java.util.List;

public class Tester {
    public static void main(String[] args) {
        System.out.println("testing");
        List<Book> bookList = BookDatabaseManager.getAllBooks();
        bookList.forEach(book -> book.printBookInfo(System.out));
    }
}
