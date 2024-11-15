package se.thinkcode.todo_spring_boot.todo.v2;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import se.thinkcode.todo_spring_boot.todo.Owner;
import se.thinkcode.todo_spring_boot.todo.Task;
import se.thinkcode.todo_spring_boot.todo.TodoService;

import java.util.List;

@Component("TaskControllerV2")
@RestController
@RequestMapping(value = "/v2")
public class TaskControllerV2 {
    private final TodoService service;

    public TaskControllerV2(TodoService service) {
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
