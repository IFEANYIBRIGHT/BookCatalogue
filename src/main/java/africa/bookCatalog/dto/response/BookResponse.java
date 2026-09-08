package africa.bookCatalog.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookResponse {
    private String id;
    private String gutenbergId;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
}


