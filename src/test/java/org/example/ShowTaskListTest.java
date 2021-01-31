package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShowTaskListTest {

    private ShowTaskList showTaskList;

    @Mock
    private Repository mockRepository;

    @Before
    public void setup() {
        showTaskList = new ShowTaskList(mockRepository);
    }

    @Test
    public void fetchTasks_shouldFetchTasksFromRepository() {
        // arrange
        Repository mockTaskRepository = new MockTaskRepository();
        ShowTaskList showTaskList = new ShowTaskList(mockTaskRepository);
        // act
        String[] result = showTaskList.fetchTasks();
        // assert
        assertEquals(3, result.length);
    }

    @Test
    public void fetchTasks_shouldMakeTaskInUpperCase() {
        Repository mockTaskRepository = new MockTaskRepository();
        ShowTaskList showTaskList = new ShowTaskList(mockTaskRepository);
        // act
        String[] result = showTaskList.fetchTasks();
        // assert
        assertEquals(3, result.length);
        assertEquals("TASK1", result[0]);
        assertEquals("TASK2", result[1]);
        assertEquals("TASK3", result[2]);
    }

    @Test
    public void fetchTasks_shouldFetchTasksFromRepository_Mockito() {
        // arrange
        when(mockRepository.getTasks()).thenReturn(new String[]{"task1", "task2", "task3"});
        // act
        String[] result = showTaskList.fetchTasks();
        // assert
        assertEquals(3, result.length);
    }

    @Test
    public void fetchTasks_shouldMakeTaskInUpperCase_Mockito() {
        when(mockRepository.getTasks()).thenReturn(new String[]{"task1", "task2", "task3"});
        // act
        String[] result = showTaskList.fetchTasks();
        // assert
        assertEquals(3, result.length);
        assertEquals("TASK1", result[0]);
        assertEquals("TASK2", result[1]);
        assertEquals("TASK3", result[2]);
    }
}