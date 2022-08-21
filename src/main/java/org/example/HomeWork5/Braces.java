package org.example.HomeWork5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*Необходимо определить,является ли последовательность скобок в строке правильной.
        Существует 3вида скобок(),[],{}-из них мы составляем последовательно вида:
        "()[]{}"->true,

        "()"->true,
        "}]{["->false,
        "(]"->false.
        Определить,какая из этих последовательность правильная-каждая открытая скобка должна закрывать скобкой того же вида.
        Для решения необходимо использовать Stack и Map.*/

public class Braces {
    public static void main(String[] args) {
        String targStr = "()[{}]{[()]}";
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        System.out.println(isCorrect(targStr, stack, map));
    }

    private static boolean isCorrect(String str, Deque<Character> stack, Map<Character, Character> map) {
        for (Character ch: str.toCharArray()) {
            if(map.containsKey(ch)){
                stack.push(ch);
            }
            if(map.containsValue(ch)){
                if(stack.isEmpty() || map.get(stack.pop()) != ch){
                    return false;
                }
            }
        }
        return true;
    }
}
