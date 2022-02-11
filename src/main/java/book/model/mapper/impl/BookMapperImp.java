package book.model.mapper.impl;

import book.model.Book;
import book.model.dto.BookDto;
import book.model.mapper.BookMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImp implements BookMapper {

    @Override
    public BookDto bookToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setDescription(book.getDescription());
        bookDto.setTitle(book.getTitle());
        return bookDto;
    }

    @Override
    public Book dtoToBook(BookDto bookDto) {
        Book book = new Book();
        book.setDescription(bookDto.getDescription());
        return book;
    }
}
