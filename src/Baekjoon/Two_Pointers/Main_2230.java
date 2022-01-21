/**
 * 수 고르기
 * https://www.acmicpc.net/problem/2230
 */
package Baekjoon.Two_Pointers;

import java.io.*;
import java.util.*;
 
public class Main_2230 {
    private static int n;
    private static int m;
    private static int[] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
 
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());
 
        Arrays.sort(arr);
 
        int ans = arr[n - 1] - arr[0];
 
        int en = 0;
        for (int st = 0; st < n; st++) {
            while (en < n && arr[en] - arr[st] < m)
                en++;
 
            if (en == n)
                break;
 
            if (ans > arr[en] - arr[st])
                ans = arr[en] - arr[st];
        }
 
        System.out.println(ans);
    }
 
}
