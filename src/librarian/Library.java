package librarian;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

public class Library {
    private final HashMap<Integer, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        for (Book b : books.values()) {
            if (b.equals(book)) {
                return;
            }
        }
        books.put(book.getId(), book);
    }

    public Book findBookById(int id) {
        return books.get(id);
    }

    public Book borrowBook(int id) throws BookIsUnavailable, BookNotExist {
        Book book = findBookById(id);
        if (book == null) throw new BookNotExist();
        book.borrowBook();
        return book;
    }

    public Book returnBook(int id) throws BookNotExist, BookAlreadyExists {
        Book book = findBookById(id);
        if (book == null) throw new BookNotExist();
        book.returnBook();
        return book;
    }

    public void fillLibrary(String filename) throws IOException {
        try (BufferedReader bf = new BufferedReader(new FileReader(filename))) {
            String line = bf.readLine();
            while (line != null) {
                Book book = makeBook(line);
                if (book != null) {
                    addBook(book);
                }
                line = bf.readLine();
            }
        }
    }

    private Book makeBook(String line) {
        String[] lines = line.split(";");
        if (lines.length != 3) return null;
        try {
            int id = Integer.parseInt(lines[0]);
            String title = lines[1].trim();
            String author = lines[2].trim();
            return new Book(id, title, author);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        String available;
        StringBuilder result = new StringBuilder();
        for (Book book : books.values()) {
            available = book.isAvailable() ? "доступна" : "выдана";
            result.append(book).append(" {").append(available).append("}\n");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Library other = (Library) obj;
        return Objects.equals(this.books, other.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
