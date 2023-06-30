package com.panish.file;

import java.io.*;
import java.util.Scanner;

public class CountWorld {

    public static void main(String[] args) {
        execute();
    }

    public static boolean execute() {
        String filePath = "src\\main\\resources\\textfiles\\CountWorld.txt";
        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null ) {
                String[] element = line.split(" ");
                count = count + element.length;
            }
            System.out.println("Total no of worlds are: " + count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
