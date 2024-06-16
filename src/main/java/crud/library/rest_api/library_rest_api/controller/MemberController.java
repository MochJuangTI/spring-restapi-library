package crud.library.rest_api.library_rest_api.controller;


import crud.library.rest_api.library_rest_api.entity.Member;
import crud.library.rest_api.library_rest_api.model.CreateMemberRequest;
import crud.library.rest_api.library_rest_api.model.MemberResponse;
import crud.library.rest_api.library_rest_api.model.UpdateMemberRequest;
import crud.library.rest_api.library_rest_api.model.WebResponse;
import crud.library.rest_api.library_rest_api.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/member"
)
public class MemberController {

    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(
            path = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MemberResponse> create(@RequestBody CreateMemberRequest request) {
        MemberResponse response = memberService.create(request);
        return WebResponse.<MemberResponse>builder().data(response).build();
    }

    @PutMapping(
            path = "/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MemberResponse> update(@RequestBody UpdateMemberRequest request) {
        MemberResponse response = memberService.update(request);
        return WebResponse.<MemberResponse>builder().data(response).build();
    }

    @DeleteMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MemberResponse> delete(@PathVariable("id") Long id) {
        MemberResponse response = memberService.delete(id);
        return WebResponse.<MemberResponse>builder().data(response).build();
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MemberResponse> get(@PathVariable("id") Long id) {
        MemberResponse response = memberService.getById(id);
        return WebResponse.<MemberResponse>builder().data(response).build();
    }

    @GetMapping(
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<MemberResponse>> getAll() {
        List<MemberResponse> response = memberService.getAll();
        return WebResponse.<List<MemberResponse>>builder().data(response).build();
    }

    @GetMapping(
            path = "/test"
    )
    public WebResponse<String> test() {
        return WebResponse.<String>builder().data("Hello World").build();
    }

}
