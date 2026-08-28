package africa.bookCatalog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    private String gutenbergId;
    private String title;
    private String author;

    @ElementCollection
    @CollectionTable(name="book_subjects",joinColumns = @JoinColumn(name="book_id"))
    @Column(name="subject")
    private List <String>allSubjects;
    private int downloadCount;
    private String coverImageUrl;


}
