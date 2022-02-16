package book.mapper.response;

import book.mapper.AuthorResponseMapper;
import book.model.Author;
import book.dto.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorResponseDto implements AuthorResponseMapper {
    @Override
    public Author dtoToAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setAuthorName(authorDto.getAuthorName());
        author.setId(author.getId());
        return author;
    }
}
