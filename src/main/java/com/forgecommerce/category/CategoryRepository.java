package com.forgecommerce.category;

// Provides built-in CRUD and database access methods
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface responsible for database operations related to database
public interface CategoryRepository extends JpaRepository<Category,Long>{
}