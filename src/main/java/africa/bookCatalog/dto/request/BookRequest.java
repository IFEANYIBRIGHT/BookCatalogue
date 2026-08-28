package africa.bookCatalog.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequest {
    private String id;
    private String gutenbergId;
    @NotBlank
    private String title;
    @NotBlank
    private String author;



}
