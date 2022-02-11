package book.model;

import book.model.dto.BookDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Description;
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

    public Book() {
    }

    public Book(Long id,
                String description,
                BigDecimal price,
                String title,
                Set<Author> authors) {
        this.id = id;
        this.Description = description;
        this.price = price;
        this.title = title;
        this.authors = authors;
    }

    public Book(String description, String title, Set<Author> authors) {
        this.Description = description;
        this.title = title;
        this.authors = authors;
    }

    public Book(String title) {
        this.title = title;
    }

 }
