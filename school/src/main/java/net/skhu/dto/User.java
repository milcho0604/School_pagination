package net.skhu.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class User {
    int id;
    int enabled;
    @NotEmpty
    @NotBlank
    @Size(min=3, max=16)
    String loginName;

    @NotEmpty
    @NotBlank
    String name;

    int departmentId;
    String password;
    String userType;

    @Email
    String email;

    String departmentName;
}
