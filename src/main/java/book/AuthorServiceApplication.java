package book;

/*
Написать  REST-API с базой данных
Сущности: Книга, Автор
Связи: У автора может быть много книг и у книг может быть несколько авторов
Создать возможность используя Postman создавать, редактировать, получать авторов по id.
Получить авторов, названия книг у которых включает опредененное слово, например,
слово "сказка" (т.е через Postman можно передать это слово/фразу.
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthorServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorServiceApplication.class, args);
    }

}
