package javaCore.mainTask;

/*
Создать массив объектов. Вывести:
a) список автомобилей заданной марки;
b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
c) список автомобилей заданного года выпуска, цена которых больше указанной.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task8 {
    public static void TaskA(ArrayList<Car> cars, String brand) {
    // Вывести список автомобилей заданной марки
        int count = 0;
        for (Car car: cars ) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(car);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("В автопарке нет автомобилей марки " + brand);
        }
    }

    public static void TaskB(ArrayList<Car> cars, String model, int n) {
    // Вывести список автомобилей заданной модели, которые эксплуатируются больше n лет
        int count = 0;
        for (Car car: cars ) {
            if (car.getModel().equalsIgnoreCase(model) &&
                    car.getAge() > n) {
                System.out.println(car);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("В автопарке нет автомобилей модели " + model + " с эксплуатацией больше " + n + " лет");
        }
    }

    public static void TaskC(ArrayList<Car> cars, int year, float price) {
    // Вывести список автомобилей заданного года выпуска, цена которых больше указанной
        int count = 0;
        for (Car car: cars ) {
            if (car.getYear() == year &&
                    car.getPrice() > price) {
                System.out.println(car);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("В автопарке нет автомобилей " + year + " года выпуска дороже " + price + " рублей");
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Car> autoPark = new ArrayList<>();
        Car.initCars(autoPark);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите марку автомобиля: ");
        String brand = reader.readLine();
        TaskA(autoPark, brand);
        System.out.println("------------------------------------------------");

        System.out.print("Введите модель автомобиля: ");
        String model = reader.readLine();
        System.out.print("Введите возраст автомобиля (лет): ");
        int age = Integer.parseInt(reader.readLine());
        TaskB(autoPark, model, age);
        System.out.println("------------------------------------------------");

        System.out.print("Введите год выпуска автомобиля: ");
        int year = Integer.parseInt(reader.readLine());
        System.out.print("Введите цену автомобиля (руб.): ");
        int price = Integer.parseInt(reader.readLine());
        TaskC(autoPark, year, price);

    }
}
