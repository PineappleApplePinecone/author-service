package book.model.mapper.impl;

import book.model.Author;
import book.model.dto.AuthorDto;
import book.model.mapper.AuthorMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImp implements AuthorMapper {

    @Override
    public AuthorDto authorToDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setAuthorName(author.getAuthorName());
        return authorDto;
    }

    @Override
    public Author dtoToAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setAuthorName(authorDto.getAuthorName());
        author.setId(author.getId());
        return author;
    }
}
