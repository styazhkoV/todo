package kz.todo.app.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentRequestDto {
@NotBlank
private String text;
}
