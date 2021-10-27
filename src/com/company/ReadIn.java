package com.company;

import java.util.Scanner;

public class ReadIn {
    public static float readValue(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        float value = scanner.nextFloat();
        while (value < 0) {
            System.out.println("Please ensure you're entering a valid number!");
            value = scanner.nextInt();
        }
        return value;
    }
}

