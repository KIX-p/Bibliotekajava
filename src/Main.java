import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Dodaj książkę");
            System.out.println("2. Usuń książkę");
            System.out.println("3. Wyszukaj po autorze");
            System.out.println("4. Wyszukaj po tytule");
            System.out.println("5. Wyjście");
            System.out.print("Wybierz opcję: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Podaj tytuł: ");
                    String title = scanner.nextLine();
                    System.out.print("Podaj imię autora: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Podaj nazwisko autora: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Podaj liczbę stron: ");
                    int pages = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Podaj ISBN: ");
                    String ISBN = scanner.nextLine();

                    Author author = new Author(firstName, lastName);
                    Book book = new Book(title, author, pages, ISBN);
                    library.dodaj(book);
                    System.out.println("Książka została dodana.");
                    break;
                case 2:
                    System.out.print("Podaj tytuł: ");
                    title = scanner.nextLine();
                    System.out.print("Podaj nazwisko autora: ");
                    lastName = scanner.nextLine();
                    author = new Author("", lastName);
                    book = library.wyszukajpoTytule(title);
                    if (book != null && book.getAuthor().getLastName().equalsIgnoreCase(author.getLastName())) {
                        library.usun(book);
                        System.out.println("Książka została usunięta.");
                    } else {
                        System.out.println("Nie znaleziono książki o podanym tytule i autorze.");
                    }
                    break;
                case 3:
                    System.out.print("Podaj nazwisko autora: ");
                    lastName = scanner.nextLine();
                    List<Book> books = library.wyszukajpoAutorze(lastName);
                    if (books.size() > 0) {
                        System.out.println("Znalezione książki:");
                        for (Book foundBook : books) {
                            System.out.println("- " + foundBook.getTitle());
                        }
                    } else {
                        System.out.println("Nie znaleziono książek o podanym nazwisku autora.");
                    }
                    break;
                case 4:
                    System.out.print("Podaj tytuł: ");
                    title = scanner.nextLine();
                    book = library.wyszukajpoTytule(title);
                    if (book != null) {
                        System.out.println("Tytuł: " + book.getTitle());
                        System.out.println("Autor: " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
                        System.out.println("Liczba stron: " + book.getPages());
                        System.out.println("ISBN: " + book.getISBN());
                    } else {
                        System.out.println("Nie znaleziono książki o podanym tytule.");
                    }
                    break;
                case 5:
                    System.out.println("Do widzenia!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
                    break;
            }
        }
    }
}
