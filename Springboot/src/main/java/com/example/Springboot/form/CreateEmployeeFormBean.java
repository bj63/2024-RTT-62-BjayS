package com.example.Springboot.form;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;
@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {

    private Integer employeeId;

    @Length(max = 100, message = "Email must be less than 100 characters")
    @NotEmpty(message="Email is required.")
    private String email;

    @Length(max = 50, message = "Firstname must be less than 50 characters")
    @NotEmpty(message = "Firstname is required.")
    private String firstName;

    @Length(max = 50, message = "Lastname must be less than 50 characters")
    @NotEmpty(message = "Lastname is required.")
    private String lastName;
    private String extension;
    private String jobTitle;
    private String office;
    private String profileImageUrl;
    private Integer vacationHours;
    private Integer officeId;

    // we are going to make this data type an integer because we know we want to write to the database as an integer
    private Integer reportsTo;


}


