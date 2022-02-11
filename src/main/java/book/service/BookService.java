package book.service;

import book.exception.BookNotFoundException;
import book.model.Author;
import book.model.Book;
import book.repository.BookRepository;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final AuthorService authorService;
    private final BookRepository bookRepository;

    @Autowired
    public BookService(AuthorService authorService, BookRepository bookRepository) {
        this.authorService = authorService;
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Set<Book> getBooksByPhrase(String phraseFromBook) {
        return bookRepository.findAll().stream()
                .filter(book -> !book.getTitle().isEmpty() && book.getTitle().contains(phraseFromBook))
                .collect(Collectors.toSet());
    }

    public Set<Book> getBooks() {
        return bookRepository
                .findAll()
                .stream()
                .collect(Collectors.toSet());
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }

    public Book deleteBook(Long bookId) {
        Book deletedBook = getBookById(bookId);
        bookRepository.delete(deletedBook);
        return deletedBook;
    }

    @Transactional
    public Book updateBook(Long bookId, Book book) {
        Book updatedBook = getBookById(bookId);
        updatedBook.setDescription(updatedBook.getDescription());
        updatedBook.setPrice(updatedBook.getPrice());
        updatedBook.setId(updatedBook.getId());
        updatedBook.setTitle(updatedBook.getTitle());
        return updatedBook;
    }

    @Transactional
    public Book addAuthorToBook(Long authorId, Long bookId) {
        Book book = getBookById(bookId);
        Author author = authorService.getAuthor(authorId);
        book.addAuthor(author);
        return book;
    }

    @Transactional
    public Book removeAuthorFromBook(Long authorId, Long bookId) {
        Book book = getBookById(bookId);
        Author author = authorService.getAuthor(authorId);
        book.removeAuthor(author);
        return book;
    }

}
