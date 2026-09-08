package africa.bookCatalog.controllers;
import africa.bookCatalog.exception.AuthorNotFoundException;
import africa.bookCatalog.model.Book;
import africa.bookCatalog.services.BookServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookServices bookServices;

    public BookController(BookServices bookServices){
        this.bookServices = bookServices;
    }

    @GetMapping("/category/{books}")
    public ResponseEntity <List<Book>>getBySubject(@PathVariable String books) throws JsonProcessingException {
        if(books == null || books.isBlank()){
            return ResponseEntity.badRequest().build();
    }
        List <Book> findBooks = bookServices.findBySubject(books);

        if(findBooks.isEmpty()){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.ok(findBooks);

}

@GetMapping("/author/{author}")
    public ResponseEntity<List<Book>>getByAuthor(@PathVariable String author) {
    if (author == null || author.isBlank()) {
        return ResponseEntity.badRequest().build();

    }
    try {
        List<Book> foundAuthor = bookServices.findByAuthor(author);
        return ResponseEntity.ok(foundAuthor);
    } catch (AuthorNotFoundException | JsonProcessingException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
    @GetMapping("/api/{search-log}")
    public ResponseEntity <List <Book >> searchLogs(@PathVariable String searchRequest) {
    if(searchRequest==null){
        return ResponseEntity.badRequest().build();
    }
    List<Book>searchedBook = bookServices.searchLogs(searchRequest);
    if(searchedBook == null){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(searchedBook);
    }


    @GetMapping("/api/search-log/{user}")
    public String requestedByWhichUser(){
        return bookServices.requestedByWho();

    }

    @GetMapping("api/search-log/{failed}")
    public boolean isResultFound(){
        return bookServices.isSearchFound();
    }

}


