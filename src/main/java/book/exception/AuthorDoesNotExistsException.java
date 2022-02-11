package book.exception;

import java.text.MessageFormat;

public class AuthorDoesNotExistsException extends RuntimeException {

    public AuthorDoesNotExistsException(Long id) {
        super(MessageFormat.format("Could not find author with id: {0}", id));
    }

}
