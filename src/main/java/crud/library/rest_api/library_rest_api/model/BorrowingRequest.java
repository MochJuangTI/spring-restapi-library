package crud.library.rest_api.library_rest_api.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowingRequest {

    private Long memberId;
    private Long bookId;

}
