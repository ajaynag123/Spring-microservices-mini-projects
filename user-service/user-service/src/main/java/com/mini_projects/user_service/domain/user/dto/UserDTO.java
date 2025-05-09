package com.mini_projects.user_service.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email cannot be empty")
    private String email;

}
