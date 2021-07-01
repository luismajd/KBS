package com.four;

import java.io.File;

public class FileManager
{
    public FileManager() {}

    public static void main(String[] args) {
        // Creates an array in which we will store the names of files and directories
        String[] pathnames;

        // Creates a new File instance by converting the given pathname string
        // into an abstract pathname
        File f = new File("persons/");

        // Populates the array with names of files and directories
        pathnames = f.list();

        // For each pathname in the pathnames array
        for (int i=pathnames.length-1; i>=0; i--) {
            // Print the names of files and directories
            System.out.println(pathnames[i]);
        }
    }
}
