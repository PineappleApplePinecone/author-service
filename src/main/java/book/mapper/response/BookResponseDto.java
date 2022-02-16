package book.mapper.response;

import book.mapper.BookResponseMapper;
import book.model.Book;
import book.dto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookResponseDto implements BookResponseMapper {
    @Override
    public Book dtoToBook(BookDto bookDto) {
        Book book = new Book();
        book.setDescription(bookDto.getDescription());
        return book;
    }
}
