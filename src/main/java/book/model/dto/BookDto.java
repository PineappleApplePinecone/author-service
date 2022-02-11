package book.model.dto;

import book.model.Book;
import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String description;
    private String title;

    public static BookDto from(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setDescription(book.getDescription());
        bookDto.setTitle(book.getTitle());
        return bookDto;
    }

    public BookDto() {
    }

    public BookDto(Long id, String description, String title) {
        this.id = id;
        this.description = description;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
