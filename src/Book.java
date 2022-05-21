import java.util.LinkedList;
import java.util.List;

public class Book {

    private String isbn;
    private String title;
    private int additionNumber;
    private String copyright;
    private List<Author> authorList;

    public Book(String isbn, String title, int additionNumber, String copyright) {
        this.isbn = isbn;
        this.title = title;
        this.additionNumber = additionNumber;
        this.copyright = copyright;
        this.authorList =new LinkedList<>();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAdditionNumber() {
        return additionNumber;
    }

    public void setAdditionNumber(int additionNumber) {
        this.additionNumber = additionNumber;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
