package book.service.impl;

import book.exception.AuthorDoesNotExistsException;
import book.model.Author;
import book.repository.AuthorRepository;
import book.service.AuthorService;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Set<Author> getAuthors() {
        return new HashSet<>(authorRepository.findAll());
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthor(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorDoesNotExistsException(id));
    }

    @Override
    public Author deleteAuthor(Long authorId) {
        Author deletedAuthor = getAuthor(authorId);
        authorRepository.delete(deletedAuthor);
        return deletedAuthor;
    }

    @Override
    @Transactional
    public Author updateAuthor(Long id, Author author) {
        Author updatedAuthor = getAuthor(id);
        updatedAuthor.setAuthorName(author.getAuthorName());
        return updatedAuthor;
    }

}
