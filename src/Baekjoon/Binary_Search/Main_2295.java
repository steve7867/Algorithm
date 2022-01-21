/**
 * 세 수의 합
 * https://www.acmicpc.net/problem/2295
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;
 
public class Main_2295 {
    private static int n;
    private static int[] arr, two;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        two = new int[n * n];
 
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
 
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                two[idx++] = arr[i] + arr[j];
            }
        }
 
        Arrays.sort(two);
 
        int ans = 0;
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                if (arr[k] - arr[l] < 0)
                    continue;
 
                int res = Arrays.binarySearch(two, arr[k] - arr[l]);
//                int res = binarySearch(arr[k] - arr[l]);
 
                if (res >= 0 && arr[k] > ans)
                    ans = arr[k];
            }
        }
 
        System.out.println(ans);
    }
 
    private static int binarySearch(int target) {
        int st = 0, en = n * n - 1;
 
        while (st <= en) {
            int mid = (st + en) / 2;
 
            if (two[mid] > target)
                en = mid - 1;
            else if (two[mid] < target)
                st = mid + 1;
            else
                return mid;
        }
 
        return -1;
    }
}