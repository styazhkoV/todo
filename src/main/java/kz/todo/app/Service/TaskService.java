package kz.todo.app.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import kz.todo.app.Entity.Task;
import kz.todo.app.Repository.TaskRepository;
import kz.todo.app.Exception.ResourceNotFoundException;
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



    
}