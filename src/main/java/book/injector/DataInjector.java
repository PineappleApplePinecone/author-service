package book.injector;

import book.model.Author;
import book.model.Book;
import book.repository.AuthorRepository;
import book.repository.BookRepository;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInjector {
    private final BookRepository bookRepository;

    @Autowired
    public DataInjector(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    private void postConstruct() {
        Author bruceEckel = new Author("BruceEckel");
        Author robertMartin = new Author("RobertMartin");
        Author robertMartinsApprentice = new Author("Apprentice");
        Author maryShelley = new Author ("MaryShelley");

        Book thinkingInJava = new Book.Builder()
                .withTitle("ThinkingInJava")
                .build();
        Book thinkingInJavaTwo = new Book.Builder()
                .withTitle("ThinkingInJavaSecondEdition")
                .build();
        Book clearCode = new Book.Builder()
                .withTitle("ClearCode")
                .build();
        Book frankenstein = new Book.Builder()
                .withTitle("Frankenstein")
                .build();
        Set<Book> setOfBooks = Set.of(thinkingInJava, clearCode, frankenstein, thinkingInJavaTwo);

        thinkingInJava.addAuthor(bruceEckel);
        thinkingInJava.addAuthor(robertMartinsApprentice);
        clearCode.addAuthor(robertMartin);
        clearCode.addAuthor(robertMartinsApprentice);
        thinkingInJavaTwo.addAuthor(maryShelley);
        frankenstein.addAuthor(maryShelley);

        bookRepository.saveAll(setOfBooks);
    }
}
