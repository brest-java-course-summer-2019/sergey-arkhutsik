package com.epam.brest2019.courses;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BigDecimal weight;
        BigDecimal distance;


        String PATH_TO_PROPERTIES = "delivery_cost/src/com/epam/brest2019/courses/resources/price_per_km.properties";
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);

            String less10 = prop.getProperty("less10");
            String less50 = prop.getProperty("less50");
            String less100 = prop.getProperty("less100");
            System.out.println("Properties file:");
            System.out.println("     less10: " + less10);
            System.out.println("     less50: " + less50);
            System.out.println("     less100: " + less100);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл " + PATH_TO_PROPERTIES + " отсуствует!");
        }

        BigDecimal pricePerKg = new BigDecimal("30");
        BigDecimal pricePerKm = new BigDecimal("40");



        System.out.println("Enter the weight in kilograms or 'q' for quit: ");
        weight = GetDataScanner();
        System.out.println("Enter the distance in kilometers or 'q' for quit: ");
        distance = GetDataScanner();


        System.out.println("Value of weight = " + weight);
        System.out.println("Value of distance = " + distance);

        BigDecimal price = weight.multiply(pricePerKg).add(distance.multiply(pricePerKm));
        System.out.println("Price = " + price);
    }

    private static BigDecimal GetDataScanner(){
        BigDecimal inputValue = null;
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        if (!inputString.equals("Q")) {
            inputValue = new BigDecimal(inputString);
        } else {
            System.out.println("\nBye!");
        }
        return inputValue;
    }
}