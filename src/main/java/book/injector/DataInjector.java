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

        Book thinkingInJava = new Book("ThinkingInJava");
        Book thinkingInJavaTwo = new Book("ThinkingInJavaSecondEdition");
        Book clearCode = new Book("ClearCode");
        Book frankenstein = new Book("Frankenstein");
        Set<Book> setOfBooks = Set.of(thinkingInJava, clearCode, frankenstein, thinkingInJavaTwo);

        thinkingInJava.addAuthor(bruceEckel);
        thinkingInJava.addAuthor(robertMartinsApprentice);
        clearCode.addAuthor(robertMartin);
        clearCode.addAuthor(robertMartinsApprentice);
        frankenstein.addAuthor(maryShelley);

        bookRepository.saveAll(setOfBooks);
    }
}
