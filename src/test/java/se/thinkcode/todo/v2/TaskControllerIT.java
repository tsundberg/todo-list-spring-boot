package se.thinkcode.todo.v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerIT {
    private String baseUrl;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/v2/";
    }

    @Test
    void should_create_task() {
        TaskResponse expected = new TaskResponse("Practice");
        createTask();
        List<TaskResponse> actualTasks = getTasks();

        assertThat(actualTasks).containsExactly(expected);
    }

    private void createTask() {
        TaskRequest request = new TaskRequest("Niklas", "Practice");
        String path = "addTask";
        WebTestClient.RequestHeadersSpec<?> postClient = WebTestClient.bindToServer()
                .baseUrl(baseUrl)
                .build()
                .post()
                .uri(path)
                .body(Mono.just(request), TaskRequest.class);
        WebTestClient.ResponseSpec actual = postClient.exchange();
        actual.expectStatus().isCreated();
    }

    private List<TaskResponse> getTasks() {
        String path;
        path = "getTasks" + "/" + "Niklas";
        WebTestClient.RequestHeadersSpec<?> getClient = WebTestClient
                .bindToServer()
                .baseUrl(baseUrl)
                .build()
                .get()
                .uri(path);
        WebTestClient.ResponseSpec actualResponse = getClient.exchange();

        actualResponse.expectStatus().isOk();
        EntityExchangeResult<List<TaskResponse>> result = actualResponse
                .expectBodyList(TaskResponse.class)
                .returnResult();

        return result.getResponseBody();
    }
}
