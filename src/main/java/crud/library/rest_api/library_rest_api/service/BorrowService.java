package crud.library.rest_api.library_rest_api.service;

import crud.library.rest_api.library_rest_api.entity.Book;
import crud.library.rest_api.library_rest_api.entity.Borrowing;
import crud.library.rest_api.library_rest_api.entity.Member;
import crud.library.rest_api.library_rest_api.model.BorrowResponse;
import crud.library.rest_api.library_rest_api.model.BorrowingRequest;
import crud.library.rest_api.library_rest_api.repository.BookRepository;
import crud.library.rest_api.library_rest_api.repository.BorrowingRepository;
import crud.library.rest_api.library_rest_api.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;

@Service
public class BorrowService {

    private final BorrowingRepository borrowingRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public BorrowService(BorrowingRepository borrowingRepository, BookRepository bookRepository, MemberRepository memberRepository) {
        this.borrowingRepository = borrowingRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public BorrowResponse borrowBook(BorrowingRequest request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "member not found") );

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found") );


        Borrowing borrowing = new Borrowing();
        borrowing.setBook(book);
        borrowing.setMember(member);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        borrowing.setCreateTimestamp(now);
        borrowingRepository.save(borrowing);

        return BorrowResponse.builder()
                .id(borrowing.getId())
                .createTimestamp(now)
                .member(member)
                .book(book).build();
    }

    public BorrowResponse reutrnBook(Long borrowId) {
        Borrowing borrowing = borrowingRepository.findById(borrowId)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "borrow not found") );

        Timestamp now = new Timestamp(System.currentTimeMillis());
        borrowing.setReturnTimestamp(now);
        borrowingRepository.save(borrowing);

        return BorrowResponse.builder()
                .id(borrowing.getId())
                .createTimestamp(now)
                .member(borrowing.getMember())
                .book(borrowing.getBook())
                .returnTimestamp(now).build();

    }

}
