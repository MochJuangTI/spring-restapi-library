package crud.library.rest_api.library_rest_api.controller;


import crud.library.rest_api.library_rest_api.entity.Member;
import crud.library.rest_api.library_rest_api.model.CreateMemberRequest;
import crud.library.rest_api.library_rest_api.model.MemberResponse;
import crud.library.rest_api.library_rest_api.model.WebResponse;
import crud.library.rest_api.library_rest_api.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(
            path = "/api/member",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<MemberResponse> create(@RequestBody CreateMemberRequest request) {
        MemberResponse response = memberService.create(request);
        return WebResponse.<MemberResponse>builder().data(response).build();
    }

    @GetMapping(
            path = "/test"
    )
    public WebResponse<String> test() {
        return WebResponse.<String>builder().data("Hello World").build();
    }

}
