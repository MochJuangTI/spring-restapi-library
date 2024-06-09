package crud.library.rest_api.library_rest_api.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowingRequest {
    @NotBlank
    private Long memberId;

    @NotBlank
    private Long bookId;

}
