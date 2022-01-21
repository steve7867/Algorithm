/**
 * 부분합
 * https://www.acmicpc.net/problem/1806
 */
package Baekjoon.Two_Pointers;

import java.io.*;
import java.util.*;
 
public class Main_1806 {
    private static int n, s;
    private static int[] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(stringTokenizer.nextToken());
        s = Integer.parseInt(stringTokenizer.nextToken());
 
        arr = new int[n];
 
        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
 
        int ans = Integer.MAX_VALUE;
        int en = 0;
        int sum = arr[0];
        for (int st = 0; st < n; sum -= arr[st], st++) {
            while (en < n && sum < s) {
                en++;
                if (en < n)
                    sum += arr[en];
            }
 
            if (en == n)
                break;
 
            if (ans > en - st + 1)
                ans = en - st + 1;
        }
 
        System.out.println((ans == Integer.MAX_VALUE) ? 0 : ans);
    }
}
