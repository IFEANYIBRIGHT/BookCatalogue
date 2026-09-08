//package services;
//
//import africa.bookCatalog.dto.request.BookRequest;
//import africa.bookCatalog.dto.response.BookResponse;
//import africa.bookCatalog.repository.BookRepository;
//import africa.bookCatalog.services.BookServices;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoSettings;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.client.RestClient;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//public class BookServicesTest {
//    @Autowired
//   private BookServices bookServices;
//    @Mock
//    private BookRepository bookRepository;
//    private RestClient restClient;
//@BeforeEach
//void setUp(){
//    bookServices = new BookServices(bookRepository,restClient);
//}
////     @Test
////    void saveABook() {
////    BookRequest book = new BookRequest();
////    book.setTitle("How to Cook");
////    book.setAuthor("Bright");
////    book.setId("12356");
////     bookRepository.save(book);
////    assertEquals(bookResponse,BookResponse.class);
////
////    }
//
//    @Test
//    void findAuthor() {
//        BookRequest book = new BookRequest();
//        book.setTitle("How to Cook");
//        book.setAuthor("Bright");
//        book.setId("12356");
//        String authorName = book.getAuthor();
//        assertEquals(authorName,book);
//    }
//
//    @Test
//    void findBySubject() {
//    }
//}