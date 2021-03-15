package javaFundamentals.mainTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task2 {
//Отобразить в окне консоли аргументы командной строки в обратном порядке.

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Аргументы командной строки в обратном порядке:");
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }
}
