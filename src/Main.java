import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Scanner bookstoreMenu = new Scanner(System.in);
        System.out.println("##--Bem-vindo(a) a livraria Bookstore!--##");
        System.out.println("Gostaria de ver os livros disponíveis?");
        System.out.println("|-----------------------------|");
        System.out.println("| Opção 1 - Sim               |");
        System.out.println("| Opção 2 - Não               |");
        System.out.println("|-----------------------------|");

        int bookstoreMenuOption = bookstoreMenu.nextInt();
        if(bookstoreMenuOption == 1) {
            System.out.println("logica dos livros");
        } else {
            System.out.println("Até logo!");
            bookstoreMenu.close();
        }
    }
}