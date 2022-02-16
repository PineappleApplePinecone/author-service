package book.mapper;

import book.dto.BookDto;
import book.model.Book;

public interface BookResponseMapper {
    Book dtoToBook(BookDto bookDto);
}
