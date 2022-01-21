/**
 * 수 정렬하기
 * https://www.acmicpc.net/problem/2750
 */
package Baekjoon.Sort1.MergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main_2750 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static int[] arr, temp;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        
        mergeSort(0, n);
        
        for (int i = 0; i < n; i++)
            sb.append(arr[i]).append("\n");
        
        System.out.println(sb);
    }
    
    private static void mergeSort(int st, int en) {
        if (st + 1 == en) return;
        
        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }
 
    private static void merge(int st, int en) {
        System.arraycopy(arr, st, temp, st, en - st);
        
        int mid = (st + en) / 2;
        int aIdx = st;
        int bIdx = mid;
        
        for (int i = st; i < en; i++) {
            if (aIdx == mid) arr[i] = temp[bIdx++];
            else if (bIdx == en) arr[i] = temp[aIdx++];
            else if (temp[aIdx] <= temp[bIdx]) arr[i] = temp[aIdx++];
            else arr[i] = temp[bIdx++];
        }
    }
 
}
