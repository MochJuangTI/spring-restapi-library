package crud.library.rest_api.library_rest_api.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMemberRequest {

    private String name;

    private String hobby;

    private String address;

}
