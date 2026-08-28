package africa.bookCatalog.repository;

import africa.bookCatalog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> searchByAuthor(String authorName);
    List<Book> findByAllSubjectsContaining(String subject);
}
