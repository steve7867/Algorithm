/**
 * 나무 자르기
 * https://www.acmicpc.net/problem/2805
 */
package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_2805 {
    private static int n, m;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
 
        arr = new int[n];
 
        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
 
        Arrays.sort(arr);
 
        int st = 0, en = 1000000000;
        while (st < en) {
            int mid = (st + en + 1) / 2;
            long res = check(mid);
            if (res >= m)
                st = mid;
            else if (res < m)
                en = mid - 1;
        }
 
        System.out.println(st);
    }
 
    private static long check(int h) {
        long sum = 0;
        for (int i : arr) {
            int temp = i - h;
            if (temp > 0)
                sum += temp;
        }
 
        return sum;
    }
}