package org.example.HomeWork6;

/*13.	**Написать программу вычисляющую значение сложного арифметического выражения. Для простоты - выражение
        всегда вычисляемое
        Пример: (2 ^ 3 * (10 / (5 - 3)))^(Sin(Pi)) ответ - 1*/


import java.util.Map;
import java.util.Stack;

public class Calculator {
    private static final String OPEN_PARENTHESES = "(";
    private static final String CLOSE_PARENTHESES = ")";

    public static void main(String[] args) {
        String inputString = "3 * 5 + ( ( 5 + 5 ) * 10 + 3 * ( 1 + 1 ) )"; //"2 + 5 - 33 * 7";
        String resultPostfix = fromInfixtoPostfix(inputString);
        System.out.println(inputString + "  " + "\n" + resultPostfix + "\n" + calculatePostfics(resultPostfix));
    }

    private static Integer calculatePostfics(String postStr) {
        Stack<Integer> operators = new Stack<>();
        Map<String, Integer> operatorsPriority = Map.of("*", 2, "/", 2, "+", 1, "-", 1);
        String[] expression = postStr.split("\\s+");

        Integer opInt1;
        Integer opInt2;
        for (String str : expression) {
            if (!operatorsPriority.containsKey(str)) {
                operators.push(Integer.valueOf(str));
            } else {
                opInt1 = operators.pop();
                opInt2 = operators.pop();
                switch (str) {
                    case "+" -> opInt2 = opInt2 + opInt1;
                    case "-" -> opInt2 = opInt2 - opInt1;
                    case "*" -> opInt2 = opInt2 * opInt1;
                    case "/" -> opInt2 = opInt2 / opInt1;
                    default -> throw new IllegalStateException("Unexpected value: " + str);
                }
                operators.push(opInt2);
            }
        }
        return operators.pop();
    }

    private static String fromInfixtoPostfix(String inputString) {
        Stack<String> operators = new Stack<>();
        StringBuilder resultString = new StringBuilder();
        Map<String, Integer> operatorsPriority = Map.of("*", 2, "/", 2, "+", 1, "-", 1, "(", 0);

        String[] expression = inputString.split("\\s+");

        int currentPosition = 0;

        while (currentPosition < expression.length) {
            String currentSymbol = expression[currentPosition];

            if (currentSymbol.equals(OPEN_PARENTHESES)) {
                operators.push(currentSymbol);

            } else if (currentSymbol.equals(CLOSE_PARENTHESES)) {
                while (!operators.peek().equals(OPEN_PARENTHESES)) {
                    resultString.append(operators.pop());
                    resultString.append(" ");
                }
                String temp = operators.pop();

            } else if (operatorsPriority.containsKey(currentSymbol)) {
                int currentPriority = operatorsPriority.get(currentSymbol);
                while (!operators.isEmpty() && currentPriority < operatorsPriority.get(operators.peek())) {
                    resultString.append(operators.pop());
                    resultString.append(" ");
                }
                operators.push(currentSymbol);
            } else {
                resultString.append(currentSymbol);
                resultString.append(" ");
            }
            currentPosition++;
        }

        while (!operators.isEmpty()) {
            resultString.append(operators.pop());
            resultString.append(" ");
        }

        return resultString.toString().trim();
    }
}
