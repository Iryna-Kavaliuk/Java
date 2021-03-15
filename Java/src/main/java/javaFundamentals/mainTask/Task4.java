package javaFundamentals.mainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
//Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите целые числа. Окончите ввод пустой строкой: ");
        int sum = 0;
        String str = reader.readLine();
        while (!str.equals("")) {
            int number = Integer.parseInt(str);
            sum += number;
            str = reader.readLine();
        }
        System.out.println("Сумма введенных чисел = " + sum);
    }
}
