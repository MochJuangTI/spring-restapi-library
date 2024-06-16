package crud.library.rest_api.library_rest_api.controller;


import crud.library.rest_api.library_rest_api.model.BorrowResponse;
import crud.library.rest_api.library_rest_api.model.BorrowingRequest;
import crud.library.rest_api.library_rest_api.model.WebResponse;
import crud.library.rest_api.library_rest_api.service.BorrowService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        path = "/api/borrow"
)
public class BorrowController {

    private final BorrowService borrowService;
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping(
            path = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<BorrowResponse> borrowBook(@RequestBody BorrowingRequest request){
        BorrowResponse borrowResponse = borrowService.borrowBook(request);
        return WebResponse.<BorrowResponse>builder().data(borrowResponse).build();
    }

    @PutMapping(
            path = "/return/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<BorrowResponse> returnBook(@PathVariable("id") Long id){
        BorrowResponse borrowResponse = borrowService.reutrnBook(id);
        return WebResponse.<BorrowResponse>builder().data(borrowResponse).build();
    }
}
