package librarianTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import taskLibrary.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class LibraryTest {


    @Test
    void borrowBook_shouldReturnUnavailableBook() throws BookIsUnavailable, BookNotExist {
        Library lib = new Library();
        lib.addBook(new Book(1, "Мастер и Маргарита", "Булгаков"));
        Book book = lib.borrowBook(1);

        assertFalse(book.isAvailable());
    }

    @Test
    void borrowBook_shouldThrowBookIsUnavailable() throws BookIsUnavailable, BookNotExist {
        Library lib = new Library();
        lib.addBook(new Book(2, "Мы", "Замятин"));
        lib.borrowBook(2);

        assertThrows(BookIsUnavailable.class, () -> lib.borrowBook(2));
    }

    @Test
    void borrowBook_shouldThrowBookNotExist() {
        Library lib = new Library();
        assertThrows(BookNotExist.class, () -> lib.borrowBook(3));
    }

    @Test
    void returnBook_shouldReturnAvailableBook() throws BookNotExist, BookAlreadyExists, BookIsUnavailable {
        Library lib = new Library();
        lib.addBook(new Book(4, "Преступление и наказание", "Достоевский"));
        lib.borrowBook(4);
        Book book = lib.returnBook(4);

        assertTrue(book.isAvailable());
    }

    @Test
    void returnBook_shouldThrowBookAlreadyExist() {
        Library lib = new Library();
        lib.addBook(new Book(5, "Вино из одуванчиков", "Рей Бредберри"));

        assertThrows(BookAlreadyExists.class, () -> lib.returnBook(5));

    }

    @Test
    void returnBook_shouldThrowBookNotExists() {
        Library lib = new Library();
        assertThrows(BookNotExist.class, () -> lib.returnBook(5));
    }

    @Test
    void fillLibrary_shouldReturnTrue() throws IOException {
        Path tmpFile = Files.createTempFile("testBook", ".txt");
        try {
            Files.writeString(tmpFile, "6;Книжный вор;Маркус Зусак");

            Library lib1 = new Library();
            Library lib2 = new Library();

            lib1.addBook(new Book(6, "Книжный вор", "Маркус Зусак"));
            lib2.fillLibrary(String.valueOf(tmpFile));

            assertEquals(lib1, lib2);
        } finally {
            Files.deleteIfExists(tmpFile);
        }
    }

    @Test
    void addBook_shouldAddNewBook() {
        Library lib = new Library();
        Book book = new Book(7, "Замок", "Кафка");
        lib.addBook(book);

        assertEquals(lib.findBookById(book.getId()), book);
    }

    @Test
    void addBook_shouldNotAddSameBook() {
        Library lib = new Library();
        Book book1 = new Book(8, "12 стульев", "Ильф, Петров");
        Book book2 = new Book(9, "12 стульев", "Ильф, Петров");

        lib.addBook(book1);
        lib.addBook(book2);
        assertTrue(lib.findBookById(8) != null && lib.findBookById(9) == null);
    }
}