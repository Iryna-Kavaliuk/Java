package javaFundamentals.mainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {
//Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

     public static void main(String[] args) throws IOException {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         System.out.print("Сколько случайных чисел вывести без перехода на новую строку? ");
         int number1 = Integer.parseInt(reader.readLine());
         System.out.print("Сколько случайных чисел вывести c переходом на новую строку? ");
         int number2 = Integer.parseInt(reader.readLine());
         System.out.println();

         //Форматированный вывод
         System.out.println(number1 + " случайных чисел без перехода на новую строку:");
         for (int i = 0; i < number1; i++) {
             System.out.print(Math.random() + "  ");
         }
         System.out.println();
         System.out.println();
         System.out.println(number2 + " случайных чисел c переходом на новую строку:");
         for (int i = 0; i < number2; i++) {
             System.out.println(Math.random());
         }
     }

}
