package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileBucket {
    private Path path;

    public FileBucket() throws IOException {
        path = Files.createTempFile(Paths.get("/Users/vlad3d/JAVA_DEVELOPER/Test2"),
                "tempfile", ".txt");

    }
}
