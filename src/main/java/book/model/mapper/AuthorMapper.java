package book.model.mapper;

import book.model.Author;
import book.model.dto.AuthorDto;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {
    AuthorDto authorToDto(Author author);
    Author dtoToAuthor(AuthorDto authorDto);
}
