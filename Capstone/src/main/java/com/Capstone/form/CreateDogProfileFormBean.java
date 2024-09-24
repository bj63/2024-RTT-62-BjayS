package com.Capstone.form;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.util.Set;

@Getter
@Setter
@ToString
public class CreateDogProfileFormBean {

    @NotEmpty(message = "Name is required")
    @Length(max = 50, message = "Name must not be over 50 characters")
    private String name;

    @NotEmpty(message = "Breed is required")
    @Length(max = 50, message = "Breed must not be over 50 characters")
    private String breed;

    @Min(value = 0, message = "Age must be a positive number")
    @Max(value = 20, message = "Age must not be over 20 years")
    private Integer age;

    @Length(max = 255, message = "Description must not be over 255 characters")
    private String description;

    @URL(message = "Invalid URL format")
    @Length(max = 255, message = "Image URL must not be over 255 characters")
    private String imageUrl;

    @NotNull(message = "Owner is required")
    @Positive(message = "Invalid Owner ID")
    private Integer ownerId;

    @NotEmpty(message = "Categories are required")
    private Set<Integer> categoryIds;  // Assuming category IDs are sent as a list of integers
    @Setter
    private Integer id;

    // Setter for ownerId to set the owner id
    public void setOwner(Integer id) {
        this.ownerId = id;
    }

    // Setter for categoryIds to set the categories
    public void setCategories(Set<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    // Getter for ownerId to get the owner id
    public Integer getOwner() {
        return this.ownerId;
    }

    // Getter for categoryIds to get the categories
    public Set<Integer> getCategories() {
        return this.categoryIds;
    }
}
