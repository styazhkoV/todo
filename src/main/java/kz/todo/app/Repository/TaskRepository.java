package kz.todo.app.Repository;

import java.util.List;

public class TaskRepository extends JpaRepository<Task, Long>{
    List<Task> findByCompleted(boolean completed);  

}
