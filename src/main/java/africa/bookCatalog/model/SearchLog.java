package africa.bookCatalog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter@Setter
@Entity
public class SearchLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID  id;

    @Column(name ="Search Type")
    private String searchType;

    @Column(name ="Search Term")
    private String searchTerm;

    @Column(name ="Requested By")
    private String requestedBy;

    @Column(name ="Request Found")
    private boolean resultFound;

    @Column(name="Result Count")
    private int resultCount;

    @Column(name ="Time Stamp")
    @CreationTimestamp
    private LocalDateTime timeStamp;


}
