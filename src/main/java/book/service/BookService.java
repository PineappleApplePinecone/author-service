package book.service;

import book.model.Book;
import java.util.Set;

public interface BookService {
    Book addBook(Book book);

    Set<Book> findByTitleContaining(String phrase);

    Set<Book> getBooks();

    Book getBookById(Long bookId);

    Book deleteBook(Long bookId);
}
