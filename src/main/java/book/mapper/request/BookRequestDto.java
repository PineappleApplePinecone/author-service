package book.mapper.request;

import book.mapper.BookRequestMapper;
import book.model.Book;
import book.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookRequestDto implements BookRequestMapper {
    @Override
    public BookDto bookToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setDescription(book.getDescription());
        bookDto.setTitle(book.getTitle());
        return bookDto;
    }
}
