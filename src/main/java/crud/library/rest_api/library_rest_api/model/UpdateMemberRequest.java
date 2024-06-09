package crud.library.rest_api.library_rest_api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateMemberRequest {

    @NotBlank
    private Long memberId;

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank
    @Size(min = 2, max = 100)
    private String hobby;

    @NotBlank
    @Size(min = 2)
    private String address;

}
