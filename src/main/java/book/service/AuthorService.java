package book.service;

import book.exception.AuthorDoesNotExistsException;
import book.model.Author;
import book.model.Book;
import book.repository.AuthorRepository;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Set<Author> getAuthors() {
        return authorRepository
                .findAll()
                .stream()
                .collect(Collectors.toSet());
    }


    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthor(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorDoesNotExistsException(id));
    }

    public Author deleteAuthor(Long authorId) {
        Author deletedAuthor = getAuthor(authorId);
        authorRepository.delete(deletedAuthor);
        return deletedAuthor;
    }

    @Transactional
    public Author updateAuthor(Long id, Author author) {
        Author updatedAuthor = getAuthor(id);
        updatedAuthor.setAuthorName(author.getAuthorName());
        return updatedAuthor;
    }

}
