import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    private UUID idLoan = UUID.randomUUID();
    private Book book;
    private Client client;
    private LocalDate loanDate = LocalDate.now();
    private LocalDate returnDate;

    Loan(Book book, Client client, LocalDate loanDate){
        this.book = book;
        this.client = client;
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

    public Client getNameClient() {
        return client;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }




    @Override
    public String toString() {
        return "Loan{" +
                "idLoan=" + idLoan +
                ", book=" + book.getBookTitle() +
                ", nameClient='" + client + '\'' +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
