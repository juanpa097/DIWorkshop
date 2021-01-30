package org.example;

import java.io.IOException;

public interface Repository {
    String[] getTasks() throws IOException;
}
