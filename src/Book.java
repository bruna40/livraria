import java.time.LocalDate;
import java.util.UUID;

public class Book {

    private UUID idBook = UUID.randomUUID();
    private String bookTitle;
    private Author author;
    private boolean isAvailable = true;
    private LocalDate registrationDate = LocalDate.now();
    private LocalDate dateUpdate = LocalDate.now();


    Book(String bookTitle, Author author) {
        this.bookTitle = bookTitle;
        this.author = author;
    }

    public UUID getIdBook() {
        return idBook;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LocalDate getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDate dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Books {"  +
                "id:" + idBook +
                ", title:'" + bookTitle + '\'' +
                ", author:" + author +
                ", available:" + isAvailable +
                ", registrationDate:" + registrationDate +
                ", dateUpdate:" + dateUpdate +
                '}';
    }

}
