package kz.todo.app.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import kz.todo.app.Entity.Task;
import kz.todo.app.Repository.TaskRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


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
        return taskRepository.findById(id).orElse(null); 
    }

    @Transactional
    public Task markAsCompleted(Long id, Task markAsCompleted) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTitle(markAsCompleted.getTitle());
            existingTask.setDescription(markAsCompleted.getDescription());
            existingTask.setCompleted(markAsCompleted.isCompleted());
            return taskRepository.save(existingTask); 
        }
        return null; 
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }


    public Task markAsCompleted(Long id) {
    // 1. Мы получаем чистую Сущность (Task), а не ResponseEntity
    Task task = getTaskById(id); 

    if (task != null) {
        // 2. Используем СЕТТЕР (setCompleted), чтобы изменить значение
        task.setCompleted(true); 
        
        // 3. Сохраняем и возвращаем
        return taskRepository.save(task); 
    }
    return null;
    }
    
}