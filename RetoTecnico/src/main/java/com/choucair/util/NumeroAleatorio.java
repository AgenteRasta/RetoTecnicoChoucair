package com.choucair.util;

import java.util.*;

public class NumeroAleatorio {
    static Random random = new Random();
    public static List<Integer> generateRandomNumbers(int max) {
        List<Integer> randomNumbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();


        while (uniqueNumbers.size() < 5) {
            int randomNumber = random.nextInt(max-1)+1; // Cambia el límite superior según tus necesidades
            uniqueNumbers.add(randomNumber);
        }

        randomNumbers.addAll(uniqueNumbers);
        return randomNumbers;
    }

    public static List<Integer> generateRandomNumbersR(int max) {
        List<Integer> randomNumbers = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            int randomNumber = random.nextInt(max-1)+1; // Cambia el límite superior según tus necesidades
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }
}
