package book.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal price;
    private String title;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id",
                    referencedColumnName = "id"))
    private Set<Author> authors = new HashSet<>();

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    public static class Builder {
        private Book book;

        public Builder() {
            book = new Book();
        }

        public Builder withId(Long id) {
            book.id = id;
            return this;
        }

        public Builder withDescription(String description) {
            book.description = description;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            book.price = price;
            return this;
        }

        public Builder withTitle(String title) {
            book.title = title;
            return this;
        }

        public Builder withAuthors(Set<Author> authors) {
            book.authors = authors;
            return this;
        }

        public Book build() {
            return book;
        }
    }
 }
