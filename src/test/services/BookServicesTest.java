//package services;
//
//import africa.bookCatalog.dto.request.BookRequest;
//import africa.bookCatalog.dto.response.BookResponse;
//import africa.bookCatalog.services.BookServices;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class BookServicesTest {
//    @Autowired
//    BookServices bookServices;
//
//@BeforeEach
//void setUp(){
//    bookServices = new BookServices();
//}
//
//    @Test
//    void saveABook() {
//    BookRequest book = new BookRequest();
//    book.setTitle("How to Cook");
//    book.setAuthor("Bright");
//    book.setId("12356");
//       BookResponse bookResponse =  bookServices.saveABook(book);
//    assertEquals(bookResponse,BookResponse.class);
//
//    }
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