package com.forgecommerce.category;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime; // Import LocalDateTime API to use Date

@Entity // Defines that this entity is a database object
@Table(name="categories") // Defines the name of collection inside the database
public class Category {

    @Id // Defines the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This filed is defined on runtime by database
    private Long id;

    @NotBlank // Doesn't allows blank data
    @Size(max = 50) // Defines the maximum size of the name field
    private String name;

    @Size(max = 250) // Defines the maximum size of the description field
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
