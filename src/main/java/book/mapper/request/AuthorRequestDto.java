package book.mapper.request;

import book.mapper.AuthorRequestMapper;
import book.model.Author;
import book.dto.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorRequestDto implements AuthorRequestMapper {
    @Override
    public AuthorDto authorToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setAuthorName(author.getAuthorName());
        return authorDto;
    }
}
