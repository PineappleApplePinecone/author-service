package book.model;

import book.model.dto.AuthorDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String authorName;

    public static Author from(AuthorDto authorDto) {
        Author author = new Author();
        author.setAuthorName(authorDto.getAuthorName());
        author.setId(author.getId());
        return author;
    }

    public Author() {
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }
}
