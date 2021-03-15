package javaFundamentals.mainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Month;

public class Task5 {
//Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число от 1 до 12: ");
        try {
            int nMonth = Integer.parseInt(reader.readLine());
            if (nMonth >= 1 && nMonth <= 12) {
                Month month = Month.of(nMonth);
                System.out.println(month);
            } else {
                System.out.println("Ошибка. Введенное число не принадлежит требуемому диапазону (1-12)!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка. Введенное значение не является целым числом!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
