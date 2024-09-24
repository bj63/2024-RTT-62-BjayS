package com.Capstone.database.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "dog_profiles")
public class DogProfile {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name="name", nullable = false, length = 50)
        private String name;

        @Column(name = "breed", nullable = false, length = 50)
        private String breed;

        @Column(name = "age", nullable = false)
        private int age;

        @Column(name = "size", nullable = false)
        private String size;

        @Column(name = "image_url", nullable = false, length = 255)
        private String imageUrl;

        @Column(name = "description", nullable = false, length = 255)
        private String description;


        @ManyToOne
        @JoinColumn(name = "owner_id", nullable = false)
        private User owner;

        @ManyToMany
        @JoinTable(
                name = "dog_profile_categories",
                joinColumns = @JoinColumn(name = "dog_profile_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id")
        )
        @ToString.Exclude
        private Set<DogCategory> categories;
}
