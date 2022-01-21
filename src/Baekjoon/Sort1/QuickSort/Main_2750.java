/**
 * 수 정렬하기
 * https://www.acmicpc.net/problem/2750
 */
package Baekjoon.Sort1.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main_2750 {
    private static int n;
    private static int[] arr, temp;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
 
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
 
        quickSort(0, n);
 
        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i).append('\n');
 
        System.out.println(sb);
    }
 
    private static void quickSort(int st, int en) {
        if (st + 1 >= en)
            return;
 
        int pivot = arr[st];
        int l = st + 1;
        int r = en - 1;
 
        while (true) {
            while (l <= r && arr[l] <= pivot)
                l++;
            while (l <= r && arr[r] > pivot)
                r--;
            if (l > r)
                break;
            swap(arr, l, r);
        }
 
        swap(arr, st, r);
        quickSort(st, r);
        quickSort(r + 1, en);
    }
 
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
 
}