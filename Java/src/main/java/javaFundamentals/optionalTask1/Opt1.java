package javaFundamentals.optionalTask1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Opt1 {
/*
Ввести n чисел с консоли.
1.Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
2.Вывести числа в порядке возрастания (убывания) значений их длины.
3.Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
4.Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
5.Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
6.Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
7.Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
*/

    public static void main(String[] args) throws IOException {

        int[] array = initArray();
 //       int[] array = {2342384, -4444, 4624, 34579, 345436, -2, 828282, 21}; // инициализация тестового массива
        System.out.println("Исходный массив: " + Arrays.toString(array));
        int[] arrayLengths = calculateElementsLengths(array);
        task1(array, arrayLengths);
        task2(array, arrayLengths);
        task3(array, arrayLengths);
        task4(array);
        task5(array);
        task6(array);
        task7(array);

    }

    public static int[] initArray () throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        while (true) {
            try {
                System.out.print("Введите размер массива n: ");
                n = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.print("Ошибка. Введенное значение не является целым числом! ");
                System.out.println("Попробуйте еще раз.");
            }
        }
        int[] array = new int[n];
        System.out.println("Введите целочисленные элементы массива");
        for (int i = 0; i < n ; i++) {
            System.out.print("элемент [" + i + "]: ");
            array[i] = Integer.parseInt(reader.readLine());
        }
        return array;
    }

    public static int[] calculateElementsLengths(int[] array) {
        //формирование массива длин каждого элемента исходного массива
        int[] lengthsArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            lengthsArray[i] = Integer.toString(array[i]).length();
        }
        return lengthsArray;
    }

    public static void task1(int[] array, int[] lengthsArray) {
        //Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        int minLength = lengthsArray[0];
        int maxLength = lengthsArray[0];
        int indexMin = 0, indexMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (lengthsArray[i] < minLength) {
                minLength = lengthsArray[i];
                indexMin = i;
            } else if (lengthsArray[i] > maxLength) {
                maxLength = lengthsArray[i];
                indexMax = i;
            }
        }
        System.out.println("---------------");
        System.out.println("Задача 1");
        System.out.println("Самое короткое число длиной " + minLength + " символов: " + array[indexMin]);
        System.out.println("Самое длинное число длиной " + maxLength + " символов: " + array[indexMax]);
    }

    public static void task2(int[] array, int[] lengthsArray) {
        //Вывести числа в порядке возрастания (убывания) значений их длины.
        int[] arraySorted = array.clone();
        int[] lengthsSorted = lengthsArray.clone();
        int k;
        for (int i = 0; i < lengthsArray.length - 1; i++) {
            for (int j = i + 1; j < lengthsSorted.length; j++) {
                if (lengthsSorted[j] < lengthsSorted[i]) {
                    k = lengthsSorted[i];
                    lengthsSorted[i] = lengthsSorted[j];
                    lengthsSorted[j] = k;
                    k = arraySorted[i];
                    arraySorted[i] = arraySorted[j];
                    arraySorted[j] = k;
                }
            }
        }
        System.out.println("---------------");
        System.out.println("Задача 2");
        System.out.println("Числа в порядке возрастания значений их длины");
        System.out.println(Arrays.toString(arraySorted));
    }

    public static void task3(int[] array, int[] lengthsArray) {
        //Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
        double averageLength = calculateAverageValue(lengthsArray);
        System.out.println("---------------");
        System.out.println("Задача 3");
        System.out.println("Числа, длина которых меньше средней длины по всем числам (<" + String.format("%.1f", averageLength) + " символов):");
        for (int i = 0; i < lengthsArray.length; i++) {
            if (lengthsArray[i] < averageLength) {
                System.out.println(array[i] + " (с длиной " + lengthsArray[i] + ")");
            }
        }
    }

    public static double calculateAverageValue(int[] array) {
        //поиск среднего арифметического значения элементов массива
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return ((double) sum / array.length);
    }

    public static void task4(int[] array) {
        //Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
        int elementMinDigits = array[0];
        int numDigits = calculateDigits(elementMinDigits);
        int minDigits = numDigits;
        for (int i = 1; i < array.length; i++) {
            numDigits = calculateDigits(array[i]);
            if (numDigits < minDigits) {
                minDigits = numDigits;
                elementMinDigits = array[i];
            }
        }
        System.out.println("---------------");
        System.out.println("Задача 4");
        System.out.println("Число с минимальным набором цифр: " + elementMinDigits);
    }

    public static int calculateDigits(int num) {
        //Подсчет неповторяющихся цифр элемента
        int count = 0;
        String sNum = Integer.toString(num);
        for (int i = 0; i < 10; i++) {
            if (sNum.contains(Integer.toString(i))) {
                count++;
            }
        }
        return count;
    }

    public static void task5(int[] array) {
        //Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
        int evenDigitsNumber = 0;       //количество чисел с только четными цифрами
        int evenOddDigitsNumber = 0;    //количество чисел с равным числом четных-нечетных цифр
        for (int i = 1; i < array.length; i++) {
            if (checkOnlyEven(array[i])) {
                evenDigitsNumber++;
//                System.out.println("a: " +array[i]); // с префиксом а: вывести числа с только четными цифрами
            } else if (checkEvenEqualOdd(array[i])) {
                evenOddDigitsNumber++;
//                System.out.println("b: " +array[i]); // с префиксом b: вывести числа с равным числом четных-нечетных цифр
            }
        }
        System.out.println("---------------");
        System.out.println("Задача 5");
        System.out.println("Количество чисел с только четными цифрами: " + evenDigitsNumber);
        System.out.println("Количество чисел с равным числом четных-нечетных цифр: " + evenOddDigitsNumber);
    }

    public static boolean checkOnlyEven (int num) {
        boolean result = true;
        String sNum = Integer.toString(num);
        int i = 1;
        while (i < 10) {
            if (sNum.contains(Integer.toString(i))) {
                result = false;
                break;
            }
            i += 2;
        }
        return (result);
    }

    public static boolean checkEvenEqualOdd (int num) {
        int remain = num;
        int even = 0;       // количество четных цифр
        int odd = 0;        // количество нечетных цифр
        do {
            if (remain % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            remain /= 10;
        } while (remain > 0);

        return (even == odd);
    }


    public static void task6(int[] array) {
        //Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
        int i = 0;
//        char [] arrDigits = String.valueOf(array[i]).toCharArray();
        while (i < array.length && !checkAscending(String.valueOf(array[i]).toCharArray())) {
            i++;
        }
        System.out.println("---------------");
        System.out.println("Задача 6");
        if (i < array.length) {
            System.out.println("Число, цифры в котором идут в строгом порядке возрастания: " + array[i]);
        } else {
            System.out.println("В массиве нет числа, цифры в котором идут в строгом порядке возрастания");
        }
    }

    public static boolean checkAscending (char [] digits) {
        boolean result = true;
 //       char [] digits = String.valueOf(num).toCharArray();
        int i = 1;
        while (i < digits.length) {
            if (digits[i - 1] >= digits [i++]) {
                result = false;
                break;
            }
        }
        return (result);
    }

    public static void task7(int[] array) {
        //Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
        int i = 0;
        char [] arrDigits;
        while (i < array.length) {
            arrDigits = String.valueOf(array[i]).toCharArray();
            Arrays.sort(arrDigits);
            if (checkAscending(arrDigits)) {
                break;
            }
            i++;
        }

        System.out.println("---------------");
        System.out.println("Задача 7");
        if (i < array.length) {
            System.out.println("Число, состоящее только из различных цифр: " + array[i]);
        } else {
            System.out.println("В массиве нет чисел, состоящех только из различных цифр");
        }
    }
}
