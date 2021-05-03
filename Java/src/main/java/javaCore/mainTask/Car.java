package javaCore.mainTask;

/*
Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
 Определить дополнительно методы в классе, создающем массив объектов.
 Задать критерий выбора данных и вывести эти данные на консоль.
 В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
*/

import java.time.LocalDate;
import java.util.ArrayList;

public class Car {
    int id;
    String brand;
    String model;
    int year;
    String color;
    float price;
    String registrationNumber;
    static int initId;

    public Car(String brand, String model, int year, String color, float price, String registrationNumber) {
        setId(initId++);
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public Car(String brand, String registrationNumber) {
        setId(initId++);
        this.brand = brand;
        setModel("Не установлено");
        setPrice(1000);
        this.registrationNumber = registrationNumber;
    }

    public Car(String brand, String model, int year, float price) {
        setId(initId++);
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        setRegistrationNumber("Не зарегистрирована");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getAge() {
        return (LocalDate.now().getYear() - year);
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
         this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String priceInfo;
        if (price == 0) {
            priceInfo = "Нет информации";
        } else {
            priceInfo = price + " руб.";
        }
        return "Car{" +
                "id='" + id + '\'' +
                ", марка='" + brand + '\'' +
                ", модель='" + model + '\'' +
                ", год=" + year +
                ", номер='" + registrationNumber + '\'' +
                ", цена: " + priceInfo +
                '}';
    }

    public static void initCars(ArrayList<Car> cars) {
        initId = 100_001;
        cars.add(new Car("Skoda","Yeti", 2013, "silver brown", 28190.00f, "2422 IB-3"));
        cars.add(new Car("Skoda", "Kodiaq", 2019, "silver green", 48199.00f, "2423 IB-3"));
        cars.add(new Car("Skoda", "Rapid", 2018, "silver metal", 18199.00f, "2424 IB-3"));
        cars.add(new Car("Skoda", "Octavia", 2010, "white", 38199.00f, "2426 IB-3"));
        cars.add(new Car("Skoda", "Superb", 2017, "black", 58199.00f, "2427 IB-3"));
        cars.add(new Car("Skoda", "Roomster", 2017, 12000f));
        cars.add(new Car("Volkswagen", "Polo", 2021, 18000f));
        cars.add(new Car("Volkswagen", "Polo", 2017, 22000f));
        cars.add(new Car("Volkswagen", "Polo", 2016, 11000f));
        cars.add(new Car("Volkswagen", "Passat", 2015, 19444.24f));
        cars.add(new Car("Volkswagen", "Passat", 2016, 12411.99f));
        cars.add(new Car("Volkswagen", "Passat", 2018, 7897.00f));
        cars.add(new Car("Mazda", "626", 2011, 11111f));
        cars.add(new Car("Mazda", "323", 2012, 12111f));
        cars.add(new Car("Mazda", "323", 2013, 13111f));
        cars.add(new Car("Mazda", "323", 2014, 14111f));
        cars.add(new Car("Mazda", "626", 2015, 15111f));
        cars.add(new Car("Mazda", "2428 IB-5"));
        cars.add(new Car("Mazda", "2429 IB-5"));
        cars.add(new Car("Mazda", "2430 IB-5"));

    }

}
