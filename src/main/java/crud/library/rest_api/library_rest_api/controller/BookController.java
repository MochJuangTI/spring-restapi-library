package crud.library.rest_api.library_rest_api.controller;


import crud.library.rest_api.library_rest_api.model.CreateBookRequest;
import crud.library.rest_api.library_rest_api.model.BookResponse;
import crud.library.rest_api.library_rest_api.model.UpdateBookRequest;
import crud.library.rest_api.library_rest_api.model.WebResponse;
import crud.library.rest_api.library_rest_api.service.BookService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/book"
)
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(
            path = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<BookResponse> create(@RequestBody CreateBookRequest request) {
        BookResponse response = bookService.create(request);
        return WebResponse.<BookResponse>builder().data(response).build();
    }

    @PutMapping(
            path = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<BookResponse> update(@RequestBody UpdateBookRequest request) {
        BookResponse response = bookService.update(request);
        return WebResponse.<BookResponse>builder().data(response).build();
    }

    @DeleteMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<BookResponse> delete(@PathVariable("id") Long id) {
        BookResponse response = bookService.delete(id);
        return WebResponse.<BookResponse>builder().data(response).build();
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<BookResponse> get(@PathVariable("id") Long id) {
        BookResponse response = bookService.getById(id);
        return WebResponse.<BookResponse>builder().data(response).build();
    }

    @GetMapping(
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<BookResponse>> getAll() {
        List<BookResponse> response = bookService.getAll();
        return WebResponse.<List<BookResponse>>builder().data(response).build();
    }
}
