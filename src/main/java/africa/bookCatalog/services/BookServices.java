package africa.bookCatalog.services;

import africa.bookCatalog.dto.request.BookRequest;
import africa.bookCatalog.dto.response.BookResponse;
import africa.bookCatalog.dto.response.GutenbergResponse;
import africa.bookCatalog.exception.AuthorNotFoundException;
import africa.bookCatalog.exception.FieldCannotBeEmpty;
import africa.bookCatalog.exception.SearchDoesNotMatchAnyBookException;
import africa.bookCatalog.exception.SubjectNotFoundException;
import africa.bookCatalog.model.Book;
import africa.bookCatalog.model.SearchLog;
import africa.bookCatalog.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServices {
     private  final BookRepository bookRepository;
    private final RestClient restClient;
    private  SearchLog searchLog;
    public BookServices(BookRepository bookRepository,RestClient restClient){

        this.bookRepository=bookRepository;
        this.restClient = restClient;
     }

    public List<Book> findBySubject(String book) throws JsonProcessingException {
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

         ObjectMapper mapper = new ObjectMapper();
        GutenbergResponse results = mapper.readValue(rawJson ,GutenbergResponse.class);
        List<Book> booksToSave =  results.getResults();
        List<Book>saved = bookRepository.saveAll(booksToSave);

        return saved ;

    }

    public List<Book> findByAuthor(String author) throws JsonProcessingException {
        List<Book> findAuthor = bookRepository.searchByAuthor(author);
        if(findAuthor == null){
            throw new AuthorNotFoundException("Author Not Found");
        }

        String rawJson = restClient.get()
                .uri("https://project-gutenberg-free-books-api1.p.rapidapi.com/books?topic=" + author)
                .header("X-RapidApi-Key","3c9ffbad4bmsha106e80bbd68a80p170ab0jsn69193beaa7c1")
                .header("X-RapidApi-Host","project-gutenberg-free-books-api1.p.rapidapi.com").retrieve()
                .body(String.class);
        if(rawJson == null ){
            throw new SubjectNotFoundException("Subject not found");
        }

         ObjectMapper mapper = new ObjectMapper();
        GutenbergResponse results = mapper.readValue(rawJson ,GutenbergResponse.class);
        List<Book> booksToSave =  results.getResults();
        List<Book>saved = bookRepository.saveAll(booksToSave);

        return findAuthor;


    }
    public  List<Book>searchLogs(String request){
        if(request== null){
            throw new SubjectNotFoundException("Field Cannot Be Null");
        }
        List<Book> foundBook = bookRepository.findByTitleContainingIgnoreCase(request);
        if(isSearchFound() ){
            throw new SearchDoesNotMatchAnyBookException("Search does not match any book");
        }
        return foundBook;
    }

    public String requestedByWho(){

        return "Search Made By "+searchLog.getRequestedBy();

    }

    public boolean isSearchFound(){
        SearchLog searchBook = new SearchLog();
       return  searchBook.isResultFound() ;

    }




}
