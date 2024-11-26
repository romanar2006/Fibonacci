package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<BigInteger> generateFibonacci(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("Число должно быть натуральным (n > 0).");
        }

        List<BigInteger> fibonacciNumbers = new ArrayList<>();
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (int i = 0; i < n; i++) {
            if (a.compareTo(new BigInteger("1000000000000000")) > 0) {
                throw new ArithmeticException("Значение числа Фибоначчи слишком велико.");
            }
            fibonacciNumbers.add(a);
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }

        return fibonacciNumbers;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите натуральное число n: ");
            String input = scanner.nextLine();

            try {
                int n = Integer.parseInt(input);
                List<BigInteger> fibonacciNumbers = generateFibonacci(n);
                System.out.println("Первые " + n + " чисел Фибоначчи: " + fibonacciNumbers);
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: Введите корректное натуральное число.");
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }
}