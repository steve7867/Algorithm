/**
 * 합이 0인 네 정수
 * https://www.acmicpc.net/problem/7453
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;
 
public class Main_7453 {
    private static int n;
    private static int[][] arr;
    private static int[] a, b;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
        arr = new int[4][n];
 
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
 
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
            arr[2][i] = Integer.parseInt(st.nextToken());
            arr[3][i] = Integer.parseInt(st.nextToken());
        }
 
        a = new int[n * n];
        b = new int[n * n];
 
        int cur = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[cur] = arr[0][i] + arr[1][j];
                b[cur] = arr[2][i] + arr[3][j];
                cur++;
            }
        }
 
        Arrays.sort(b);
 
        long ans = 0;
        for (int j : a) {
            int l = getLowerBound(b, -j);
            int u = getUpperBound(b, -j);
            ans += u - l;
        }
 
        System.out.println(ans);
    }
 
    private static int getLowerBound(int[] arr, int target) {
        int st = 0, en = arr.length;
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] >= target)
                en = mid;
            else
                st = mid + 1;
        }
 
        return st;
    }
 
    private static int getUpperBound(int[] arr, int target) {
        int st = 0, en = arr.length;
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] > target)
                en = mid;
            else
                st = mid + 1;
        }
 
        return st;
    }
}
