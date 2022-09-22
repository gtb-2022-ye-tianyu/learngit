package assignment.todo.java.console.app.tdd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    public TaskRepository() {
    }

    List<Task> loadTasks() {
        final List<String> lines = readTaskLines();
        final List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            tasks.add(TaskFactory.creatTask(i + 1, lines.get(i)));
        }
        return tasks;
    }

    List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoException();
        }
    }


    List<String> create(Task task) {
        final var taskName = task.getName();
        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH, StandardOpenOption.APPEND)) {
            bw.write("+ " + taskName);
        } catch (IOException e) {
            throw new TodoException();
        }
        return List.of();
    }

    public void mark(ArrayList<Integer> idList) {
        final var tasks = loadTasks();

        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH)) {
            for (Task task : tasks) {
                if (idList.contains(task.getId()) && !task.isCompleted()) {
                    bw.write("x " + task.getName());
                    bw.newLine();
                    continue;
                }
                var completedSIgn = task.isCompleted() ? "x" : "+";
                bw.write(completedSIgn + " " + task.getName());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new TodoException();
        }

    }
}
