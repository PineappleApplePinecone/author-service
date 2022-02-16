package book.mapper;

import book.dto.AuthorDto;
import book.model.Author;

public interface AuthorResponseMapper {
    Author dtoToAuthor(AuthorDto authorDto);
}
