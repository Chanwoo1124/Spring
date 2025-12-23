package hello.login.web.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginForm {
    @NotEmpty
    private String loginId;
    @NotNull
    private String password;

}
