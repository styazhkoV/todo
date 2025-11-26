package kz.todo.app.Service;
import kz.todo.app.Entity.Task;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createNewTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }
}
