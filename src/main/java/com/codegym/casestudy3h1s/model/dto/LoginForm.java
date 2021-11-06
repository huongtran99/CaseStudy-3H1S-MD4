package com.codegym.casestudy3h1s.model.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class LoginForm {
    @NotEmpty
    @Size(min = 6,max = 18)
    private String username;

    @NotEmpty
    @Size(min = 6,max = 18)
    private String password;
}
