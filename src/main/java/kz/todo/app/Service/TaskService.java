package kz.todo.app.Service;

import jakarta.validation.Valid;
import kz.todo.app.DTO.CommentRequestDto;
import kz.todo.app.DTO.CommentResponseDto;
import lombok.NonNull;
import lombok.experimental.NonFinal;
import org.hibernate.annotations.Comments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import kz.todo.app.Entity.Task;
import kz.todo.app.Repository.TaskRepository;
import kz.todo.app.Exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private Long taskId;


    public List<Task> getTasksByStatus(boolean isCompleted) {
        return taskRepository.findByCompleted(isCompleted);
    }

    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id)); 
    }

    @Transactional
    public Task updateTask(Long id, Task taskDetails) {
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        existingTask.setTitle(taskDetails.getTitle());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setCompleted(taskDetails.isCompleted());
        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public CommentResponseDto addCommentToTask(Long taskId, @Valid CommentRequestDto commentDto) {
        Task task = getTaskById(taskId);
        return null;
    };

}