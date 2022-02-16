package book.mapper;

import book.dto.BookDto;
import book.model.Book;

public interface BookRequestMapper {
    BookDto bookToDto(Book book);
}
