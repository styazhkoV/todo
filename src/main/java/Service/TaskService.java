package kz.todo.app.Service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor; // Лучше использовать Required для final полей
import kz.todo.app.Entity.Task;
import kz.todo.app.Repository.TaskRepository;
import java.util.List;

@Service
@RequiredArgsConstructor // Создаст конструктор для taskRepository
public class TaskService { // УБИРАЕМ extends TaskRepository

    private final TaskRepository taskRepository; // Внедряем зависимость

    // Правильное имя метода и синтаксис
    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        // null - это опасно. Лучше выбрасывать ошибку, но пока оставим так.
        return taskRepository.findById(id).orElse(null); 
    }
}