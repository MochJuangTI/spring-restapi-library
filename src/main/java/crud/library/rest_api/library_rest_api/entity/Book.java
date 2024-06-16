package crud.library.rest_api.library_rest_api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    private Long id;

    private String title;

    private String author;

    @Column(name = "is_borrowed")
    private boolean isBorrowed;

    @OneToMany(mappedBy = "book")
    private List<Borrowing> borrowing;
}
