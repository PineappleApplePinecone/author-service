package book.controller;

import book.model.Author;
import book.model.Book;
import book.model.dto.AuthorDto;
import book.model.dto.BookDto;
import book.service.AuthorService;
import book.service.BookService;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDto> addBook(@RequestBody final BookDto bookDto) {
        Book book = bookService.addBook(Book.from(bookDto));
        return new ResponseEntity<>(BookDto.from(book), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<BookDto>> getBooks() {
        Set<Book> setOfBooks = bookService.getBooks();
        Set<BookDto> setOfBookDtos = setOfBooks.stream()
                .map(BookDto::from)
                .collect(Collectors.toSet());
        return new ResponseEntity<>(setOfBookDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/phrase")
    public ResponseEntity<Set<AuthorDto>> getAuthorsByPhrase(@RequestParam String phraseFromBooksTitle) {
        Set<Book> books = bookService.getBooksByPhrase(phraseFromBooksTitle);
        Set<AuthorDto> setOfAuthorDtos = books.stream()
                .flatMap(book -> book.getAuthors().stream())
                .map(AuthorDto::from)
                .collect(Collectors.toSet());
        return new ResponseEntity<>(setOfAuthorDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable final Long id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(BookDto.from(book), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{bookId}")
    public  ResponseEntity<BookDto> deleteBook(@PathVariable final Long bookId) {
        Book book = bookService.deleteBook(bookId);
        return new ResponseEntity<>(BookDto.from(book), HttpStatus.OK);
    }

    @PutMapping(value = "/{bookId}")
    public ResponseEntity<BookDto> updateBook(@PathVariable final Long bookId,
                                              @RequestBody final BookDto bookDto) {
        Book updatedBook = bookService.updateBook(bookId, Book.from(bookDto));
        return new ResponseEntity<>(BookDto.from(updatedBook), HttpStatus.OK);
    }

    @PostMapping(value = "/{bookId}/books/{authorId}/add")
    public ResponseEntity<BookDto> addAuthorToBook(@PathVariable final Long bookId,
                                                   @PathVariable final Long authorId) {
        Book book = bookService.addAuthorToBook(bookId, authorId);
        return new ResponseEntity<>(BookDto.from(book), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{bookId}/books/{authorId}/remove")
    public ResponseEntity<BookDto> removeAuthorFromBook(@PathVariable final Long bookId,
                                                   @PathVariable final Long authorId) {
        Book book = bookService.removeAuthorFromBook(bookId, authorId);
        return new ResponseEntity<>(BookDto.from(book), HttpStatus.OK);
    }
}
