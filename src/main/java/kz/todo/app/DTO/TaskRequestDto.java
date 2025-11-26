package kz.todo.app.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequestDto {
    @NotBlank(message = "Title cannot be blank")
    private String title; 
    private String description;
    private boolean completed;    
}
