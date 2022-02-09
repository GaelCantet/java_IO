package com.training.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isOk = false;
        while (!isOk) {
            try {
                System.out.println("Quel est le chemin de votre fichier ?");
                String path = scan.nextLine();
                Reader fileReader = new FileReader(path);
                int data = fileReader.read();
                while (data != -1) {
                    System.out.println(data);
                    data = fileReader.read();
                }
                isOk = true;
            } catch (InputMismatchException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
