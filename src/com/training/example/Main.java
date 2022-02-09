package com.training.example;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

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
                List<Integer> unicodeList = new ArrayList<Integer>();
                while (data != -1) {
                    unicodeList.add(data);
                    data = fileReader.read();
                }
                Set<Integer> uniqueSet = new HashSet<Integer>(unicodeList);
                for (Integer i : uniqueSet) {
                    String character = String.valueOf(Character.toChars(i));
                    System.out.println(character + " (Unicode : " + i + "): " + Collections.frequency(unicodeList, i));
                }
                isOk = true;
            } catch (InputMismatchException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
