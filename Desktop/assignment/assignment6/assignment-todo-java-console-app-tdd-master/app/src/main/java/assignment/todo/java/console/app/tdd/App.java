package assignment.todo.java.console.app.tdd;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class App {

    private final ResultMessage resultMessage = new ResultMessage();

    public static void main(String[] args) {

        new App().run().forEach(System.out::println);
    }

    public List<String> run(String... args) {
        if (args == null || args.length == 0) {
            return new ListCommand().run();
        }

        File file = Constants.TASKS_FILE_PATH.toFile();
        String result = null;
        if (!file.exists() && args[0].equals("init")) {
            try {
                Files.createDirectory(Path.of(Constants.USER_HOME_PATH, Constants.TODO_CONFIG_ROOT));
                boolean tasksFile = new File(String.valueOf(Constants.TASKS_FILE_PATH)).createNewFile();
                if (tasksFile) {
                    result = "Initialized successfully.";
                }
            } catch (IOException e) {
                throw new TodoException();
            }
            return resultMessage.resultMessage(result);
        } else if (!file.exists() && !args[0].equals("init")) {
            result = "please run 'todo init' before running " + args[0] + " command.";
            return resultMessage.resultMessage(result);
        } else if (file.exists() && args[0].equals("init")) {
            result = "You have initialized.";
            return resultMessage.resultMessage(result);
        } else {
            if (args[0].equals("add")) {
                String[] restArgs = Arrays.copyOfRange(args, 1, args.length);
                return new AddCommand(new TaskRepository(), restArgs).execute();
            } else if (args[0].equals("mark")) {
                return new MarkCommand(new TaskRepository(), args).execute();
            }
        }
        return new ListCommand().run();
    }

}
