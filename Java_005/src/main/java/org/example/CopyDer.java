package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class CopyDer {

    private File FromDer;
    private File ToDer;


    public CopyDer(File FromDer, File ToDer) {
        this.FromDer = FromDer;
        this.ToDer = ToDer;
    }


    public void copyDirectory() {

        if (!ToDer.exists()) {
            ToDer.mkdir();
        }
        File[] files = FromDer.listFiles();
        if (files != null) {

            for (File file : files) {
                if (file.isFile()) {
                    File backupFile = new File(ToDer, file.getName());
                    try {
                        Files.copy(file.toPath(), backupFile.toPath());
                        System.out.println("Файла скопированы " + file.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}