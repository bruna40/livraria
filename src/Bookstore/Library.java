package Bookstore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loan = new ArrayList<>();

    public static void main(String[] args) {
        Author author1 = new Author("Robert C. Martin", LocalDate.of(1952, 12,5));
        Author author2 = new Author("Aditya Y. Bhargava", LocalDate.of(1974, 04, 6));
        System.out.println(author1);
        System.out.println(author2);

        Book book1 = new Book("Arquitetura Limpa", author1);
        Book book2 = new Book("Entendendo algoritmos", author2);
        System.out.println(book1);
        System.out.println(book2);



    }

}
