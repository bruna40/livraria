import java.time.LocalDate;
import java.util.UUID;

public class Author {
    private UUID idAuthor = UUID.randomUUID();
    private String nameAuthor;
    private LocalDate dateOfBirth;

    public Author(String nameAuthor, LocalDate dateOfBirth) {
      this.nameAuthor = nameAuthor;
      this.dateOfBirth = dateOfBirth;
    }

    public UUID getIdAuthor() {
        return idAuthor;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor:" + idAuthor +
                ", nameAuthor:'" + nameAuthor + '\'' +
                ", dateOfBirt:" + dateOfBirth +
                '}';
    }

}
