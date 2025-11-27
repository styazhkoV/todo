package kz.todo.app.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp; // Удобнее для старта
import java.time.LocalDateTime;
import java.util.List;

@Entity             // 1. Обязательно: Это сущность БД
@Data               // 2. Lombok: Геттеры, Сеттеры, toString
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @jakarta.validation.constraints.NotBlank // Валидация
    private String title;

    private String description;
    
    private boolean completed;

    @CreationTimestamp // 3. Hibernate сам заполнит время при сохранении
    @Column(updatable = false) // Дату создания менять нельзя
    private LocalDateTime createdAt; // Имя переменной - createdAt, Тип - LocalDateTime
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
}