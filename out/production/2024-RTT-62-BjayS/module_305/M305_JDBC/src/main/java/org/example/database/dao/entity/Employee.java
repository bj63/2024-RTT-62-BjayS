package org.example.database.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "office_id")
    private Integer officeId;

   @Column (name = "firstname")
   private String firstName;

    @Column (name = "lastname")
    private String lastName;

    @Column (name = "email")
    private String email;

    @Column (name = "job_title")
    private String jobTitle;

    @Column (name = "vacation_hours")
    private Integer vacationHours;

    @Column (name = "profile_image_url")
    private String profileImageUrl;

    public void setExtension(String number) {
    }
}
