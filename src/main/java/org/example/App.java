package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Path taskFilePath = Paths.get("src/main/resources/MyTasks.txt");
        Repository repository = new TaskRepository(taskFilePath);

        ShowTaskList showTaskList = new ShowTaskList(repository);

        String[] tasks = showTaskList.fetchTasks();

        for (String task : tasks) {
            System.out.println(task);
        }
    }
}

