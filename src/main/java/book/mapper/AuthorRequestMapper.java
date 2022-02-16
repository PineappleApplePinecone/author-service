package book.mapper;

import book.dto.AuthorDto;
import book.model.Author;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorRequestMapper {
    AuthorDto authorToDto(Author author);
}
