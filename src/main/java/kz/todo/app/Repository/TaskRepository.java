package kz.todo.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import kz.todo.app.Entity.Task;
import java.util.List;

// ЭТО ИНТЕРФЕЙС! extends JpaRepository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Spring САМ напишет SQL запрос: SELECT * FROM tasks WHERE completed = ?
    List<Task> findByCompleted(boolean completed);

    // Можно добавлять другие методы по имени, но тело писать НЕ НУЖНО.
    // Например:
    // List<Task> findByTitleContaining(String keyword);
}