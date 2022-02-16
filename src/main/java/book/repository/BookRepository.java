package book.repository;

import book.model.Book;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "FROM Book AS b JOIN FETCH b.authors WHERE b.title LIKE ?1")
    Set<Book> findByTitleContaining(String phrase);
}
