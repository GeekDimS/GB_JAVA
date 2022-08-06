package org.example;

// 3.	+Написать программу вычисления n-ого треугольного числа.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input n ");
        int n = sc.nextInt();
        triangularNumberSearch(n);
    }

    public static void triangularNumberSearch(int n) {
        int tn;
        tn = n*(n+1)/2;
        System.out.println(tn);
    }
}