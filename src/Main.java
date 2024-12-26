import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void listAvalableBooks (List<Book> availableBooks) {
        for(int i=0; i < availableBooks.size(); i++) {
            System.out.println((i + 1) + " - " + availableBooks.get(i).getBookTitle());
        }
    }

    public static void main(String[] args) {
        Scanner bookstoreMenu = new Scanner(System.in);
        Library library = new Library();
        List<Client> clients = new ArrayList<>();

        Author author1 = new Author("Robert C. Martin", LocalDate.of(1952, 12,5));
        Book book1 = new Book("Arquitetura Limpa", author1);

        Author author2 = new Author("Aditya Y. Bhargava", LocalDate.of(1974, 4, 6));
        Book book2 = new Book("Entendendo algoritmos", author2);

        Author author3 = new Author("Joshua Bloch", LocalDate.of(1961, 8, 28));
        Book book3 = new Book("Effective Java", author3);

        Author author4 = new Author("Robert Sedgewick", LocalDate.of(1946, 4, 8));
        Book book4 = new Book("Algoritmos", author4);

        Author author5 = new Author("Kent Beck", LocalDate.of(1961, 3, 6));
        Book book5 = new Book("Test-Driven Development", author5);

        Author author6 = new Author("Martin Fowler", LocalDate.of(1963, 4, 18));
        Book book6 = new Book("Refactoring", author6);



        library.addNewBook(book1);
        library.addNewBook(book2);
        library.addNewBook(book3);
        library.addNewBook(book4);
        library.addNewBook(book5);
        library.addNewBook(book6);



        System.out.println("##--Bem-vindo(a) a livraria Bookstore!--##");

        boolean continueMenu =true;

        while (continueMenu) {
            System.out.println("O que você gostaria de fazer?");
            System.out.println("|-----------------------------|");
            System.out.println("| Opção 1 - Ver livros        |");
            System.out.println("| Opção 2 - Emprestar livro   |");
            System.out.println("| Opção 3 - Listar Clientes   |");
            System.out.println("| Opção 4 - Cadastrar Cliente |");
            System.out.println("| Opção 5 - Sair              |");
            System.out.println("|-----------------------------|");

            // Verificar se e possivel criar um funcao ja que a logica se repete
            if(!bookstoreMenu.hasNextInt()) {
                System.out.println("Entrada inválida. Digite um número.");
                bookstoreMenu.nextLine();
                continue;
            }

            int bookstoreMenuOption = bookstoreMenu.nextInt();

            switch (bookstoreMenuOption) {
                case 1:
                    List<Book> availableBooks = library.getAllBooksAvailable();
                    if(availableBooks.isEmpty()) {
                        System.out.println("Nenhum livro disponível no momento");
                    } else {
                        System.out.println("Livros disponíveis:");
                        listAvalableBooks(availableBooks);
                    }
                    break;

                case 2:
                    List<Book> booksToBorrow = library.getAllBooksAvailable();

                    if(booksToBorrow.isEmpty()) {
                        System.out.println("Nenhum livro disponível no momento");
                    } else {
                        System.out.println("Qual livro deseja pegar emprestado:");
                        listAvalableBooks(booksToBorrow);

                        if(!bookstoreMenu.hasNextInt()) {
                            System.out.println("Entrada inválida. Digite um número.");
                            bookstoreMenu.nextLine();
                            continue;
                        }
                        int chosenBookIndex = bookstoreMenu.nextInt() -1;

                        if(chosenBookIndex >= 0 && chosenBookIndex < booksToBorrow.size()) {
                            Book chosenBook = booksToBorrow.get(chosenBookIndex);
                            System.out.println("Digite seu Id:");
                            bookstoreMenu.nextLine();
                            String borrowerNameString = bookstoreMenu.nextLine();
                            UUID borrowerName = UUID.fromString(borrowerNameString);
                            library.borrowTheBook(chosenBook.getIdBook(), borrowerName);
                            System.out.println("Livro emprestado: " + chosenBook.getBookTitle());
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    }
                    break;

                case 3:
                    break;

                case 4:
                    // adicionei o bookstoreMenu.nextLine();, pois resolveu problema de nao ta pegando o nome
                    bookstoreMenu.nextLine();
                    System.out.println("Digite o nome do Cliente:");
                    String nameClient = bookstoreMenu.nextLine();
                    System.out.println("Digite o email do cliente:");
                    String emailClient = bookstoreMenu.nextLine();
                    System.out.println("Digite a data de nascimento do cliente: dd/mm/yyyy");
                    String dateOfBirth = bookstoreMenu.nextLine();
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    try {
                        LocalDate formatedDate = LocalDate.parse(dateOfBirth, format);
                        Client newClient = new Client(nameClient, emailClient, formatedDate);
                        clients.add(newClient);
                        System.out.println("Cadastro do cliente realizado com sucesso!!!!");
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de data inválido. Por favor, use dd/mm/yyyy.");
                    }
                    break;
                case 5:
                    System.out.println("Até logo!");
                    continueMenu = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        bookstoreMenu.close();
    }
}