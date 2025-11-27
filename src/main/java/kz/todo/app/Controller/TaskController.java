package kz.todo.app.Controller;

import kz.todo.app.Mapper.TaskMapper;
import kz.todo.app.Repository.TaskRepository;
import kz.todo.app.Entity.Task;
import kz.todo.app.Service.TaskService;
import kz.todo.app.DTO.TaskRequestDto;
import kz.todo.app.DTO.TaskResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;



@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskRequestDto taskRequestDto) {
        Task task = taskMapper.toEntity(taskRequestDto);
        Task createdTask = taskService.createNewTask(task);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(taskMapper.toDto(createdTask));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(taskMapper.toDtoList(tasks));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(taskMapper.toDto(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequestDto taskRequestDto) {
        Task updatedTaskData = taskMapper.toEntity(taskRequestDto);
        Task updatedTask = taskService.markAsCompleted(id, updatedTaskData);
        return ResponseEntity.ok(taskMapper.toDto(updatedTask));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // ОСТАВЛЯЕМ ТОЛЬКО ЭТОТ МЕТОД ДЛЯ ПОИСКА
    // URL будет: GET /tasks/search?isCompleted=true
    @GetMapping("/search")
    public ResponseEntity<List<TaskResponseDto>> searchTasksByStatus(@RequestParam boolean isCompleted) {
        List<Task> tasks = taskService.getTasksByStatus(isCompleted);
        return ResponseEntity.ok(taskMapper.toDtoList(tasks));          
    }

    @PostMapping("path")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
   

}
    