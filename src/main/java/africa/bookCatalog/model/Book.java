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
    @Column(name="gutenbergId")
    private String gutenbergId;

    @Column(name="Title")
    private String title;

    @Column(name="Author")
    private String author;
    @ElementCollection
    @CollectionTable(name="book_subjects",joinColumns = @JoinColumn(name="book_id"))
     @Column(name="subject")
    private List <String>allSubjects;

    @Column(name="DownLoadCount ")
    private int downloadCount;

    @Column(name="CoverImage")
    private String coverImageUrl;


}
