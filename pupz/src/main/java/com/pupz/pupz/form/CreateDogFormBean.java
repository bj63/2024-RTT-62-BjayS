package com.pupz.pupz.form;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDogFormBean {
    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 0, message = "Age must be a positive number")
    private int age;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Description is required")
    private String description;

    private String imageUrl;

    @NotNull(message = "Owner is required")
    private Long userId;
}