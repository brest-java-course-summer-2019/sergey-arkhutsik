package com.epam.brest2019.courses;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static BigDecimal[] array1;
    private static BigDecimal pricePerKm;

    public static void main(String[] args) {

        BigDecimal weight;
        BigDecimal distance;
        BigDecimal pricePerKg = new BigDecimal("30");


        System.out.println("Enter the weight in kilograms or 'q' for quit: ");
        weight = getDataScanner();
        System.out.println("Enter the distance in kilometers or 'q' for quit: ");
        distance = getDataScanner();
        readProperties("delivery_cost/src/resources/price_per_km.properties");
        pricePerKm = compareDistance(distance);

        System.out.println("Value of weight = " + weight);
        System.out.println("Value of distance = " + distance);
        System.out.println("Cost for 1 km = " + pricePerKm);

        BigDecimal price = weight.multiply(pricePerKg).add(distance.multiply(pricePerKm));
        System.out.println("Price = " + price);
    }

    private static BigDecimal getDataScanner(){
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

    private static BigDecimal[] readProperties(String PATH_TO_PROPERTIES){
        array1 = new BigDecimal[3];
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            String less10 = prop.getProperty("less10");
            String less50 = prop.getProperty("less50");
            String less100 = prop.getProperty("less100");
            array1[0] = new BigDecimal(less10);
            array1[1] = new BigDecimal(less50);
            array1[2] = new BigDecimal(less100);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл " + PATH_TO_PROPERTIES + " отсуствует!");
        }
        return array1;
    }

    private static BigDecimal compareDistance(BigDecimal distance){
        if (distance.compareTo(BigDecimal.valueOf(10)) <= 0){
            return array1[0];
        } else  if(distance.compareTo(BigDecimal.valueOf(50)) <= 0){
            return array1[1];
        } else  if(distance.compareTo(BigDecimal.valueOf(100)) <= 0) {
            return array1[2];
        } else {
            return BigDecimal.valueOf(50);
        }

    }

}