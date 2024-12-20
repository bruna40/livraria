package Bookstore;

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

    public void getAllBooksAvailable() {
        boolean hasAvailableBooks = false;

        for (Book book: books) {
            if(book.isAvailable()) {
                System.out.println(book);
                hasAvailableBooks = true;
            }
        }

        if(!hasAvailableBooks)
            System.out.println("There are no books available in the library.");
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
            }
            return;
        }
        System.out.println("Ops! Não encontramos nenhum livro com o ID " + idBook + ". Que tal tentar novamente?");
    }

//    public static void main(String[] args) {
//        Author author1 = new Author("Robert C. Martin", LocalDate.of(1952, 12,5));
//        Book book1 = new Book("Arquitetura Limpa", author1);
//
//        Author author2 = new Author("Aditya Y. Bhargava", LocalDate.of(1974, 4, 6));
//        Book book2 = new Book("Entendendo algoritmos", author2);
//
//        Author author3 = new Author("Joshua Bloch", LocalDate.of(1961, 8, 28));
//        Book book3 = new Book("Effective Java", author3);
//
//        Author author4 = new Author("Robert Sedgewick", LocalDate.of(1946, 4, 8));
//        Book book4 = new Book("Algoritmos", author4);
//
//        Author author5 = new Author("Kent Beck", LocalDate.of(1961, 3, 6));
//        Book book5 = new Book("Test-Driven Development", author5);
//
//        Author author6 = new Author("Martin Fowler", LocalDate.of(1963, 4, 18));
//        Book book6 = new Book("Refactoring", author6);
//
//
//        Library library = new Library();
//        library.addNewBook(book1);
//        library.addNewBook(book2);
//        library.addNewBook(book3);
//        library.addNewBook(book4);
//        library.addNewBook(book5);
//        library.addNewBook(book6);
//
//        library.getAllBooksAvailable();
//
//        library.borrowTheBook(book1.getIdBook(), "Bruna Maria");
//        library.getAllBooksAvailable();
//
//    }

}
