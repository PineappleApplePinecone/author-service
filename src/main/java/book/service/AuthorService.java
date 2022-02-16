package book.service;

import book.model.Author;
import java.util.Set;

public interface AuthorService {
    Set<Author> getAuthors();

    Author addAuthor(Author author);

    Author getAuthor(Long id);

    Author deleteAuthor(Long authorId);

    Author updateAuthor(Long id, Author author);
}
