import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    private UUID idLoan = UUID.randomUUID();
    private Book book;
    private String nameClient;
    private LocalDate loanDate = LocalDate.now();
    private LocalDate returnDate;

    Loan(Book book, String nameClient, LocalDate loanDate){
        this.book = book;
        this.nameClient = nameClient;
        this.loanDate = loanDate;
        this.returnDate = loanDate.plusDays(7);
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public UUID getIdLoan() {
        return idLoan;
    }

    public String getNameClient() {
        return nameClient;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }




    @Override
    public String toString() {
        return "Loan{" +
                "idLoan=" + idLoan +
                ", book=" + book.getBookTitle() +
                ", nameClient='" + nameClient + '\'' +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
