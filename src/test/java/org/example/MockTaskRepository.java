package org.example;

public class MockTaskRepository implements Repository {
    @Override
    public String[] getTasks() {
        return new String[] {"task1", "task2", "task3"};
    }
}
