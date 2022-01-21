/**
 * 수 고르기
 * https://www.acmicpc.net/problem/2230
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;
 
public class Main_2230 {
    private static int n;
    private static int m;
    private static long[] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(br.readLine());
 
        Arrays.sort(arr);
 
        long ans = arr[n - 1] - arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] + m > arr[n - 1])
                continue;
 
            int l = getLowerBound(arr[i] + m);
            long gap = arr[l] - arr[i];
            if (ans > gap)
                ans = gap;
        }
 
        System.out.println(ans);
    }
 
    private static int getLowerBound(long target) {
        int st = 0, en = n;
        while (st < en) {
            int mid = (st + en) / 2;
            if (arr[mid] >= target)
                en = mid;
            else
                st = mid + 1;
        }
 
        return st;
    }
}
