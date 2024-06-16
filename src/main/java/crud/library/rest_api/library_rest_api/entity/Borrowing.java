package crud.library.rest_api.library_rest_api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "borrowings")
public class Borrowing {

    @Id
    private Long id;

    @Column(name = "created_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createTimestamp;

    @Column(name = "return_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp returnTimestamp;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

}
