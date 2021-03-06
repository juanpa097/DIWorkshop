package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TaskRepository implements Repository {

    private static final String SEPARATOR = "/n";

    private final Path tasksFilePath;

    public TaskRepository(Path tasksFilePath) {
        this.tasksFilePath = tasksFilePath;
    }

    @Override
    public String[] getTasks() {
        try {
            String content = Files.readString(tasksFilePath);
            return content.split(SEPARATOR);
        } catch (IOException e) {
            return new String[0];
        }
    }
}
