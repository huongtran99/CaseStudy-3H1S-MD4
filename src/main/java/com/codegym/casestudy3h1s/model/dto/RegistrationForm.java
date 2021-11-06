package com.codegym.casestudy3h1s.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm {
    @NotEmpty
    @Size(min = 4, max = 20)
    private String name;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", message = "* invalid email")
    private String email;

    @NotEmpty
    @Size(min = 4, max = 20)
    private String password;
}
