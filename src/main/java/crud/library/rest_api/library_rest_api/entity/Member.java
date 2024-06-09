package crud.library.rest_api.library_rest_api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "members")
public class Member {

    @Id
    private Long id;

    private String name;

    private String hobby;

    private String address;

    @OneToMany(mappedBy = "member")
    private List<Borrowing> borrowing;

}
