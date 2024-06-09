package crud.library.rest_api.library_rest_api.repository;

import crud.library.rest_api.library_rest_api.entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}
