package crud.library.rest_api.library_rest_api.model;

import crud.library.rest_api.library_rest_api.entity.Book;
import crud.library.rest_api.library_rest_api.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BorrowResponse {
    private Long id;
    private Timestamp createTimestamp;
    private Timestamp returnTimestamp;
    private Member member;
    private Book book;
}
