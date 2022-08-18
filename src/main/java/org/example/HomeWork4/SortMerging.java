package org.example.HomeWork4;

// +Реализовать алгоритм сортировки слиянием

import java.util.Arrays;

public class SortMerging {
    public static void main(String[] args) {
        int[] arr = new int[]{9,1,3,2,8,5,7};
        Sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void Sort(int[] arr, int s, int e) { // s-start, e - end, h - half
        if (s == e) {
            return;
        }
        int h = (e - s) / 2;
        Sort(arr, s, s + h);
        Sort(arr, s + h + 1, e);
        Merge(arr, s, e, s + h);
    }

    private static void Merge(int[] arr, int s, int e, int h) {
        int i1 = 0, i2 = 0, i0 = 0;
        int size1 = h - s + 1;
        int size2 = e - h;
        int[] arr1 = new int[h - s + 1];
        int[] arr2 = new int[e - h];

        if (size1 >= 0) System.arraycopy(arr, s, arr1, 0, size1);

        for (int i = 0; i < size2; i++) {
            arr2[i] = arr[h + i + 1];
        }

        while (i1 < size1 && i2 < size2) {
            if (arr1[i1] < arr2[i2]) {
                arr[s + i0] = arr1[i1];
                i1++;
            } else {
                arr[s + i0] = arr2[i2];
                i2++;
            }
            i0++;
        }
        while (i1 < size1) {
            arr[s + i0] = arr1[i1];
            i0++;
            i1++;
        }
        while (i2 < size2) {
            arr[s + i0] = arr2[i2];
            i0++;
            i2++;
        }
    }
}
