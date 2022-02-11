package book.model.dto;

import book.model.Author;
import book.model.Book;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class AuthorDto {
    private Long id;
    private String authorName;
}
