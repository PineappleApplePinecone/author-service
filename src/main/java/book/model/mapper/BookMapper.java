package book.model.mapper;

import book.model.Book;
import book.model.dto.BookDto;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    BookDto bookToDto(Book book);
    Book dtoToBook(BookDto bookDto);
}
