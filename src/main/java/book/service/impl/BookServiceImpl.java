package book.service.impl;

import book.exception.BookNotFoundException;
import book.model.Author;
import book.model.Book;
import book.repository.BookRepository;
import book.service.BookService;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final AuthorServiceImpl authorService;
    private final BookRepository bookRepository;
    private static final String ANY_CHAR = "%";

    @Autowired
    public BookServiceImpl(AuthorServiceImpl authorService, BookRepository bookRepository) {
        this.authorService = authorService;
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public Set<Book> findByTitleContaining(String value) {
        return bookRepository.findByTitleContaining(ANY_CHAR  + value + ANY_CHAR);
    }

    @Override
    public Set<Book> getBooks() {
        return new HashSet<>(bookRepository.findAll());
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }

    @Override
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
