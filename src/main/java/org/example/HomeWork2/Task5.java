package org.example.HomeWork2;

/* 5.	*+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2?
+?5=69.Требуется восстановить выражение до верного равенства.Предложить хотя бы одно решение или сообщить,что его нет.*/

import java.util.Arrays;
import java.util.HashSet;

public class Task5 {
    public static char[] questionsChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static HashSet<String> combinationsSet = new HashSet<>();

    public static void main(String[] args) {
        String expression = "?? + ?6 = 69";
        expression = expression.replace(" ", "");

        int countChar = (int) expression.chars().filter(ch -> ch == '?').count();

/*        int N  = 3; // количество элементов в массиве
        int k  = 2; // в массиве могут быть числа ниже указанного
        int[] nums = new int[N];
        generate(nums, 0, k);*/

        combinations("", "0123456789", countChar);
        for (String s : combinationsSet) {
            calculate(expression, s, countChar);
        }
    }

    public static void combinations(String prefix, String strFull, int lengthArray) {
        if (prefix.length() > lengthArray) {
            return;
        }
        if (prefix.length() == lengthArray) {
            combinationsSet.add(prefix);
        }
        for (char symbol : strFull.toCharArray()) {
            combinations(prefix + symbol, strFull, lengthArray);
        }
    }

    private static void generate(int[] arrays, int index, int k) {
        if (index == arrays.length) {
            System.out.println(Arrays.toString(arrays));
            return;
        }

        for (int i = 0; i < k; i++) {
            arrays[index] = i;
            generate(arrays, index + 1, k);
        }
    }

    private static void calculate(String exprStr, String combStr, int count){
        int index = 0;
        for(int i = 0; i < exprStr.length(); i++){
            if (exprStr.charAt(i) == '?'){
                exprStr = exprStr.substring(0, i) + combStr.charAt(index) + exprStr.substring(i+1);
                index++;
            }
        }
        String answerString = exprStr.substring(exprStr.indexOf("=") + 1);
        String number1String = exprStr.substring(0, exprStr.indexOf("+"));
        String number2String = exprStr.substring(exprStr.indexOf("+") + 1, exprStr.indexOf("="));
        int res = Integer.parseInt(number1String) + Integer.parseInt(number2String);
        int answer = Integer.parseInt(answerString);

        if (res == answer) {
            System.out.println(exprStr);
        }
    }
}
