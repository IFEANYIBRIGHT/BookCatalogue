package africa.bookCatalog.dto.response;

import africa.bookCatalog.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class GutenbergResponse {
    private String next;
    private String previous;
    private List<Book> results;

}
