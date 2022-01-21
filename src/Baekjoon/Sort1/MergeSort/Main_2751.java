/**
 * 수 정렬하기 2
 * https://www.acmicpc.net/problem/2751
 */
package Baekjoon.Sort1.MergeSort;

import java.io.*;
 
public class Main_2751 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr, tmp;
            
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        
        mergeSort(0, n);
        
        for (int i = 0; i < n; i++)
            sb.append(arr[i]).append("\n");
        
        System.out.println(sb);
    }   
    
    private static void mergeSort(int st, int en) {
        if (st == en - 1) return;
        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }
    
    private static void merge(int st, int en) {
        System.arraycopy(arr, st, tmp, st, en - st);
        
        int mid = (st + en) / 2;
        int aIdx = st, bIdx = mid;
        for (int i = st; i < en; i++) {
            if (aIdx == mid) arr[i] = tmp[bIdx++];
            else if (bIdx == en) arr[i] = tmp[aIdx++];
            else if (tmp[aIdx] <= tmp[bIdx]) arr[i] = tmp[aIdx++];
            else arr[i] = tmp[bIdx++];
        }
    }
    
}