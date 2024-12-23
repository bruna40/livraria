import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public void addNewBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooksAvailable() {
        List<Book> availableBooks = new ArrayList<>();
        boolean hasAvailableBooks = false;

        for (Book book: books) {
            if(book.isAvailable()) {
                availableBooks.add(book);
                hasAvailableBooks = true;
            }
        }

        if(!hasAvailableBooks) {
            System.out.println("There are no books available in the library.");
        }

        return availableBooks;
    }

    public void borrowTheBook(UUID idBook, String clientName) {
        for(Book book: books) {
            if(book.getIdBook().equals(idBook)) {
                if(!book.isAvailable()) {
                    System.out.println("O livro já está emprestado: " + book.getBookTitle());
                    return;
                }
                book.setAvailable(false);
                Loan loan = new Loan(book, clientName, LocalDate.now());
                loans.add(loan);
                System.out.println("Empréstimo realizado com sucesso para '" + book.getBookTitle() + "' ao usuário " + clientName + ".");
                return;
            }

        }
        System.out.println("Ops! Não encontramos nenhum livro com o ID " + idBook + ". Que tal tentar novamente?");
    }


}
