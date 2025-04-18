package librarian;

import java.io.IOException;
import java.util.Scanner;

public class Librarian {
    private final Library library;
    private final Scanner scanner = new Scanner(System.in);

    public Librarian(String filename) {
        library = new Library();
        try {
            library.fillLibrary(filename);
        } catch (IOException e) {
            System.out.println("> невозможно создать библиотеку: файл не найден");
        }
    }

    public void start() {
        System.out.println("""
                Добро пожаловать в библиотеку!
                
                Вот что вы можете делать:
                b [ID] - взять книгу
                r [ID] - вернуть книгу
                p - узнать, какие книги у нас есть
                e - покинуть библиотеку
                """);
        String ans = scanner.nextLine();
        while (!ans.equals("e")) {
            String[] answers = ans.split(" ");
            switch (answers[0]) {
                case "b" -> borrowBook(answers[1]);
                case "r" -> returnBook(answers[1]);
                case "p" -> printAllBooks();
                default -> System.out.println("введите корректную команду!");
            }
            ans = scanner.nextLine();
        }
    }

    private void borrowBook(String st_id) {
        try {
            int id = Integer.parseInt(st_id);
            Book book = library.borrowBook(id);
            System.out.println("> вы взяли книгу " + book.toString());
        } catch (NumberFormatException e) {
            System.out.println("> неверный ID, попробуйте снова");
        } catch (BookIsUnavailable e) {
            System.out.println("> книги нет в наличии");
        } catch (BookNotExist e) {
            System.out.println("> такой книги нет в библиотеке");
        }
    }

    private void returnBook(String st_id) {
        try {
            int id = Integer.parseInt(st_id);
            Book book = library.returnBook(id);
            System.out.println("> вы вернули книгу " + book.toString());
        } catch (NumberFormatException e) {
            System.out.println("> неверный ID, попробуйте снова");
        } catch (BookAlreadyExists e) {
            System.out.println("> такая книга уже существует в библиотеке");
        } catch (BookNotExist e) {
            System.out.println("> такой книги нет в библиотеке\n" +
                    "Хотите подарить ее? y/n");
            int id = Integer.parseInt(st_id);
            if (scanner.next().equalsIgnoreCase("y")) library.addBook(new Book(id, scanTitle(), scanAuthor()));
        }
    }

    private String scanTitle() {
        System.out.println("Введите название книги:");
        String title = scanner.nextLine();
        return title.isBlank() ? "untitled" : title;
    }

    private String scanAuthor() {
        System.out.println("Введите автора книги:");
        String author = scanner.nextLine();
        return author.isBlank() ? "unknown" : author;
    }

    private void printAllBooks() {
        System.out.println(library.toString());
    }
}
