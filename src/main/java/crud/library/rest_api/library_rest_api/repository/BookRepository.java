package crud.library.rest_api.library_rest_api.repository;

import crud.library.rest_api.library_rest_api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
