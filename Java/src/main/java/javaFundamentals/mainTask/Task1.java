package javaFundamentals.mainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
//Приветствовать любого пользователя при вводе его имени через командную строку.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Как Ваше имя? ");
        String name;
        name = reader.readLine();
        System.out.println("Добро пожаловать, " + name + "!");
    }

}
