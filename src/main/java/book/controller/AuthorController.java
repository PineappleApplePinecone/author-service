package book.controller;

import book.model.Author;
import book.model.Book;
import book.model.dto.AuthorDto;
import book.service.AuthorService;
import book.service.BookService;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {
    private final AuthorService authorService;


    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;

    }

    @PostMapping
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody final AuthorDto authorDto) {
        Author author = authorService.addAuthor(Author.from(authorDto));
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<AuthorDto>> getAuthors() {
        Set<Author> setOfAuthors = authorService.getAuthors();
        Set<AuthorDto> setOfAuthorDtos = setOfAuthors.stream()
                .map(AuthorDto::from)
                .collect(Collectors.toSet());
        return new ResponseEntity<>(setOfAuthorDtos, HttpStatus.OK);

    }

    @GetMapping(value = "/{authorId}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable final Long authorId) {
        Author author = authorService.getAuthor(authorId);
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{authorId}")
    public ResponseEntity<AuthorDto> deleteAuthor(@PathVariable final long authorId) {
        Author author = authorService.deleteAuthor(authorId);
        return new ResponseEntity<>(AuthorDto.from(author), HttpStatus.OK);
    }

    @PutMapping(value = "/{authorId}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable final Long authorId,
                                                  @RequestBody final AuthorDto authorDto) {
        Author updatedAuthor = authorService.updateAuthor(authorId, Author.from(authorDto));
        return new ResponseEntity<>(AuthorDto.from(updatedAuthor), HttpStatus.OK);
    }
}
