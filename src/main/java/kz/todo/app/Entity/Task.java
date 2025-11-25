package kz.todo.app.Entity;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String title;
    private String description;     
    private boolean completed;
    private CreatedDate LocalDateTime;

}
