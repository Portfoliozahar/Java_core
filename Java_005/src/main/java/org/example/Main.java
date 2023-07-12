package org.example;

import java.io.File;


public class Main {


    public static void main(String[] args) {

        File sourceFolder = new File("./FromDer");

        File backupFolder = new File("./backup");


        CopyDer copier = new CopyDer(sourceFolder, backupFolder);

        copier.copyDirectory();
    }
}