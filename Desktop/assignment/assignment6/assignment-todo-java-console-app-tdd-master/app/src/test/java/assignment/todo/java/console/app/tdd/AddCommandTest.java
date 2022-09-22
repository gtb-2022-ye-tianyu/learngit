package assignment.todo.java.console.app.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AddCommandTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
    }

    @Test
    void should_compose_task_name_using_multiple_args() {
        final var strings = new String[]{"fizz", "buzz"};
        final AddCommand command = creatCommandFrom(strings);

        command.execute();

        verify(taskRepository).create(new Task(0, "fizz buzz", false));
    }

    @Test
    void should_use_empty_name_when_no_args_provided() {
        final var strings = new String[]{};
        final AddCommand command = creatCommandFrom(strings);

        command.execute();

        verify(taskRepository).create(new Task(0, "", false));
    }

    private AddCommand creatCommandFrom(String[] strings) {
        return new AddCommand(taskRepository, strings);
    }

}
