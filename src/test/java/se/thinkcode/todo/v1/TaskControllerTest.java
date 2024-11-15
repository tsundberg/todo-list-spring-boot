package se.thinkcode.todo.v1;

import org.junit.jupiter.api.Test;
import se.thinkcode.todo.InMemoryTodoRepository;
import se.thinkcode.todo.TodoRepository;
import se.thinkcode.todo.TodoService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskControllerTest {
    @Test
    void should_create_task() {
        TaskResponse expected = new TaskResponse("Öva");
        TodoRepository repository = new InMemoryTodoRepository();
        TodoService service = new TodoService(repository);
        TaskControllerV1 controller = new TaskControllerV1(service);
        TaskRequest task = new TaskRequest("Kalla", "Öva");

        controller.createTask(task);
        List<TaskResponse> tasks = controller.getTasks("Kalla");

        assertThat(tasks).containsExactly(expected);
    }
}
