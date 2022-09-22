package assignment.todo.java.console.app.tdd;

import java.util.List;

public class AddCommand {
    private final String[] args;
    final TaskRepository taskRepository;

    public AddCommand(TaskRepository taskRepository, String... args) {
        this.args = args;
        this.taskRepository = taskRepository;
    }

    List<String> execute() {
        final var taskName = String.join(" ", args);
        return taskRepository.create(new Task(0, taskName, false));
    }

}
