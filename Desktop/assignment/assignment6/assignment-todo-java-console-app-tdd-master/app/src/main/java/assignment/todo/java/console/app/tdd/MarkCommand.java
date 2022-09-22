package assignment.todo.java.console.app.tdd;

import java.util.ArrayList;
import java.util.List;

public class MarkCommand {
    private final TaskRepository taskRepository;
    private final String[] args;

    public MarkCommand(TaskRepository taskRepository, String[] args) {
        this.taskRepository = taskRepository;
        this.args = args;
    }

    public List<String> execute() {

        ArrayList<Integer> idList = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            idList.add(Integer.valueOf(args[i]));
        }
        this.taskRepository.mark(idList);
        return List.of();
    }
}
