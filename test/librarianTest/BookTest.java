package librarianTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import librarian.Book;
import librarian.BookAlreadyExists;
import librarian.BookIsUnavailable;


class BookTest {
    @Test
    void borrowBook_shouldMakeBookUnavailable() throws BookIsUnavailable {
        Book book = new Book(1, "Мастер и Маргарита", "Булгаков");
        book.borrowBook();

        assertFalse(book.isAvailable());
    }

    @Test
    void borrowBook_shouldThrowIfAlreadyBorrowed() throws BookIsUnavailable {
        Book book = new Book(2, "Преступление и наказание", "Достоевский");
        book.borrowBook();

        assertThrows(BookIsUnavailable.class, book::borrowBook);
    }

    @Test
    void  returnBook_shouldMakeBookAvailable() throws BookAlreadyExists, BookIsUnavailable {
        Book book = new Book(3, "Лолита", "Набоков");
        book.borrowBook();
        book.returnBook();

        assertTrue(book.isAvailable());
    }

    @Test
    void returnBook_shouldThrowIfAlreadyReturned() throws BookAlreadyExists {
        Book book = new Book(4, "Золотой жук","Эдгар Алан По");

        assertThrows(BookAlreadyExists.class, book::returnBook);
    }
}