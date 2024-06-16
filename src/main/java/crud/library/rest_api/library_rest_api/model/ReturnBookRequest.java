package crud.library.rest_api.library_rest_api.model;

import jakarta.validation.constraints.NotBlank;

public class ReturnBookRequest {

    @NotBlank
    private String borrowId;
}
