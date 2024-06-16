package crud.library.rest_api.library_rest_api.service;


import crud.library.rest_api.library_rest_api.entity.Book;
import crud.library.rest_api.library_rest_api.model.CreateBookRequest;
import crud.library.rest_api.library_rest_api.model.BookResponse;
import crud.library.rest_api.library_rest_api.model.UpdateBookRequest;
import crud.library.rest_api.library_rest_api.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public BookResponse create(CreateBookRequest request) {
        Book book = new Book();

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        bookRepository.save(book);

        return toBookResponse(book);
    }


    @Transactional
    public BookResponse update(UpdateBookRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found") );

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());

        bookRepository.save(book);

        return toBookResponse(book);
    }

    @Transactional
    public BookResponse delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found") );

        bookRepository.delete(book);
        return toBookResponse(book);
    }

    public BookResponse getById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found") );

        return toBookResponse(book);
    }

    public List<BookResponse> getAll() {
        List<Book> books = bookRepository.findAll();

        List<BookResponse> listBooks = List.of();
        for (Book book : books) {
            listBooks.add(toBookResponse(book));
        }
        return listBooks;
    }


    private BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor()).build();

    }

}
