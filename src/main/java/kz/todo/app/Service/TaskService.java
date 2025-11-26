package kz.todo.app.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Важно для транзакций
import lombok.RequiredArgsConstructor;
import kz.todo.app.Entity.Task;
import kz.todo.app.Repository.TaskRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    public Task getTaskById(Long id) {
        // Возвращаем null или можно кинуть ошибку позже
        return taskRepository.findById(id).orElse(null); 
    }

    @Transactional // Гарантирует, что обновление пройдет целиком или не пройдет вообще
    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        
        if (existingTask != null) {
            // Обновляем поля
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setCompleted(updatedTask.isCompleted());
            
            // save() для существующего ID работает как UPDATE
            return taskRepository.save(existingTask); 
        }
        return null; 
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByStatus(boolean isCompleted) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTasksByStatus'");
    }
}