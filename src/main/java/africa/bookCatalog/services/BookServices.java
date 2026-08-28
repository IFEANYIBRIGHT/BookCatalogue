package africa.bookCatalog.services;

import africa.bookCatalog.exception.AuthorNotFoundException;
import africa.bookCatalog.exception.SubjectNotFoundException;
import africa.bookCatalog.model.Book;
import africa.bookCatalog.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
@Service
public class BookServices {
     private  final BookRepository bookRepository;
    private final RestClient restClient;

    public BookServices(BookRepository bookRepository,RestClient restClient){

        this.bookRepository=bookRepository;
        this.restClient = restClient;
    }

    public List<Book> findBySubject(String book){
        List<Book> findSubject = bookRepository.findByAllSubjectsContaining(book);

        if(!findSubject.isEmpty()){
            return  findSubject;
        }
    String rawJson = restClient.get()
            .uri("https://project-gutenberg-free-books-api1.p.rapidapi.com/books?topic=" + book)
            .header("X-RapidApi-Key","3c9ffbad4bmsha106e80bbd68a80p170ab0jsn69193beaa7c1")
            .header("X-RapidApi-Host","project-gutenberg-free-books-api1.p.rapidapi.com").retrieve()
                .body(String.class);
        if(rawJson == null ){
            throw new SubjectNotFoundException("Subject not found");
        }
        return List.of();

    }

    public List<Book> findByAuthor(String author){
        List<Book> findAuthor = bookRepository.searchByAuthor(author);
        if(findAuthor == null){
            throw new AuthorNotFoundException("Author Not Found");
        }
        return findAuthor;


    }




}
