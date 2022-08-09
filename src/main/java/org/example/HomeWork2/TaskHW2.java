package org.example.HomeWork2;

/* Сделать программу, в рамках которой необходимо определить какой символ сколько раз встречается в строке. Например:
        входящая строка вида - "aaaaabbbbcddd" мы должны получить - "a5b4c1d3".*/

public class TaskHW2 {

    public static void main(String[] args) {
        String inpStr = "aaaaabbbbcddd";
        String res = makeRLE(inpStr);
        System.out.println(res);
    }

    private static String makeRLE(String inpStr) {
        char[] chArr = inpStr.toCharArray();
        char temp = inpStr.charAt(0);
        int count = 0;
        StringBuilder resSB = new StringBuilder();
        for (char ch : chArr) {
            if (temp != ch){
                resSB.append(temp);
                resSB.append(count);
                count = 1;
                temp = ch;
            }
            else{
                count ++;
            }
        }
        resSB.append(temp);
        resSB.append(count);
        return resSB.toString();
    }
}
