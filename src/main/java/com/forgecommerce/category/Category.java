package com.forgecommerce.category;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime; // Provides date and time without timezone information

@Entity // Marks this class as a JPA entity that is mapped to the database
@Table(name="categories") //  Maps this entity to the "categories" database table
public class Category {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // The database generates the ID when a new row is inserted
    private Long id;

    @NotBlank // Prevents the value from being null, empty, or only whitespace
    @Size(max = 50) // Limits the name to a maximum of 50 characters
    private String name;

    @Size(max = 250) // Limits the description to a maximum of 250 characters
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Category(){
    }

    // Getter Methods
    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Setter Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
