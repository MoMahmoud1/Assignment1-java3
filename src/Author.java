import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private List<Book> bookList = new ArrayList<>();

    public Author(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(int id, String firstName, String lastName, List<Book> bookList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void printAuthorInfo(PrintStream printStream){
        printStream.printf("\nId: %d \t\t First Name: %s \t\t Last Name: %s ",
                this.getId(),this.getFirstName(),this.getLastName());


    }
}
