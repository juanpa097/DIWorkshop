package org.example;

import java.util.Arrays;

public class ShowTaskList {

    private final Repository repository;

    public ShowTaskList(Repository repository) {
        this.repository = repository;
    }

    public String[] fetchTasks() {
        return Arrays.stream(repository.getTasks())
                .map((String::toUpperCase))
                .toArray(String[]::new);
    }
}
