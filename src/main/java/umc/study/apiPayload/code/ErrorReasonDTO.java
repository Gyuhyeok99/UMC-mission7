package umc.study.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ErrorReasonDTO {

    private Boolean isSuccess;
    private String code;
    private String message;
    private HttpStatus httpStatus;

    public boolean getIsSuccess(){return isSuccess;}

}
