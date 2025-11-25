package kz.todo.app.Service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import kz.todo.app.Entity.Task;
import kz.todo.app.Repository.TaskRepository;   
@Service
@AllArgsConstructor 
public class TaskService extends TaskRepository {
    create new Task(Task task) {
        return save(task);
    }
    public List<Task> getAllTasks() {
        return findAll();
    }
    public Task getTaskById(Long id) {
        return findById(id).orElse(null);   
}
