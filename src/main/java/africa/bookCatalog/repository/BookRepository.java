package africa.bookCatalog.repository;

import africa.bookCatalog.dto.request.BookRequest;
import africa.bookCatalog.dto.response.BookResponse;
import africa.bookCatalog.model.Book;
import africa.bookCatalog.model.SearchLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    List<Book> searchByAuthor(String author);
    List<Book> findByAllSubjectsContaining(String allSubjects);
    List<Book> findByTitleContainingIgnoreCase(String title); }
