package se.thinkcode.todo_spring_boot.todo.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.thinkcode.todo_spring_boot.todo.Owner;
import se.thinkcode.todo_spring_boot.todo.Task;
import se.thinkcode.todo_spring_boot.todo.TodoService;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class TaskControllerV1 {
    private final TodoService service;

    public TaskControllerV1(TodoService service) {
        this.service = service;
    }

    @PostMapping("/addTask")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody TaskRequest task) {
        Task taskModel = task.getTask();
        Owner ownerModel = task.getOwner();
        service.createTask(taskModel, ownerModel);
    }

    @GetMapping("/getTasks/{owner}")
    public List<TaskResponse> getTasks(@PathVariable String owner) {
        Owner ownerModel = new Owner(owner);
        List<Task> taskList = service.getTasks(ownerModel);
        return TaskResponse.fromModel(taskList);
    }
}
