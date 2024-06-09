package crud.library.rest_api.library_rest_api.repository;

import crud.library.rest_api.library_rest_api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
