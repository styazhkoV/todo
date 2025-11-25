package kz.todo.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository; // Не забудь импорт
import kz.todo.app.Entity.Task;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompleted(boolean completed);
}