package librarian;

import java.util.Objects;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() throws BookIsUnavailable {
        if (!isAvailable) throw new BookIsUnavailable();
        isAvailable = false;
    }

    public void returnBook() throws BookAlreadyExists {
        if (isAvailable) throw new BookAlreadyExists();
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "{ID: " + id + "} \"" + title + "\" -- " + author;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return this.title.equalsIgnoreCase(book.title)
                && this.author.equalsIgnoreCase(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), author.toLowerCase());
    }
}
