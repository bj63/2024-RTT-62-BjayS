package com.example.Springboot.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateCustomerFormBean {

    @Length(max = 100, message = "Customer name must be less than 100 characters")
    @NotEmpty(message="Customer name is required.")
    private String customerName;

    @Length(max = 50, message = "First name must be less than 50 characters")
    @NotEmpty(message = "First name is required.")
    private String contactFirstname;

    @Length(max = 50, message = "Last name must be less than 50 characters")
    @NotEmpty(message = "Last name is required.")
    private String contactLastname;

    @Length(max = 15, message = "Phone must be less than 15 characters")
    private String phone;

    @Length(max = 100, message = "Address Line 1 must be less than 100 characters")
    private String addressLine1;

    @Length(max = 100, message = "Address Line 2 must be less than 100 characters")
    private String addressLine2;

    @Length(max = 50, message = "City must be less than 50 characters")
    private String city;

    @Length(max = 50, message = "State must be less than 50 characters")
    private String state;

    @Length(max = 15, message = "Postal Code must be less than 15 characters")
    private String postalCode;

    @Length(max = 50, message = "Country must be less than 50 characters")
    private String country;

    private Double creditLimit;

    public Integer getSalesRepEmployeeId() {
        return null;

    }
}
