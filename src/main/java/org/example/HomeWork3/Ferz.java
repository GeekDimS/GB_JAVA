package org.example.HomeWork3;

public class Ferz {

    static int Size = 4;
    static  int[][] arrTable = new int[Size][Size];
    public static void main(String[] args) {
        goFerz(0);  //запускаем перебор с первого (нулевого) столбца
    }

    private static void goFerz(int col) {
        for (int i = 0; i < Size; i++) { //цикл по строкам столбца
            if (col == Size) {  // выход из функции, если все столбцы перебрали
                return;
            }
            if (arrTable[i][col] != 0) {    // выход из очередной ветки, если данная клетка под ударом
                continue;
            }
            putFerz(i,col); // отмечаем клетки под ударом вправо для данного расположения ферзя
            goFerz(col + 1);    //начинаем проверку следующего столбцов
            if(col+1==Size){    //если дошли до этой команды, значит успешно дошли до конца ветки.
                System.out.println(" ");    // и можно распечатать очередной вариант
                for (int k = 0; k < Size; k++) {
                    for (int l = 0; l < Size; l++) {
                        if (arrTable[k][l] == 0) {
                            System.out.print(" 0 ");
                        }else{
                            System.out.print(" 1 ");
                        }
                    }
                    System.out.println("");
                }
            }
            deleteFerz(i,col);    // очищаем клетки от угрозы от данного размещения ферзя для следующих веток
        }
    }

    private static void deleteFerz(int row, int col){
        for(int i=0; i<Size; i++) {
            arrTable[i][col] -= 1;
        }
        for (int i = col; i < Size; i++) {
            arrTable[row][i] -= 1;
        }
        int r = row+1;
        int c = col+1;
        while (r<Size && c<Size) {
            arrTable[r][c] -= 1;
            r+=1;
            c+=1;
        }
        r = row-1;
        c = col+1;
        while (r>=0 && c<Size) {
            arrTable[r][c] -= 1;
            r-=1;
            c+=1;
        }
        arrTable[row][col]=0;
    }


    private static void putFerz(int row, int col) {
        for(int i=0; i<Size; i++) {
            arrTable[i][col] += 1;
        }
        for (int i = col; i < Size; i++) {
            arrTable[row][i] += 1;
        }
        int r = row+1;
        int c = col+1;
        while (r<Size && c<Size) {
            arrTable[r][c] += 1;
            r+=1;
            c+=1;
        }
        r = row-1;
        c = col+1;
        while (r>=0 && c<Size) {
            arrTable[r][c] += 1;
            r-=1;
            c+=1;
        }
        arrTable[row][col]=0;
    }


}
