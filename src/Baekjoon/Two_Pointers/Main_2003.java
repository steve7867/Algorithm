/**
 * 수들의 합 2
 * https://www.acmicpc.net/problem/2003
 */
package Baekjoon.Two_Pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        int[] arr = new int[n];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
 
        int r = -1;
        int sum = 0;
        int cnt = 0;
        for (int l = 0; l < n; sum -= arr[l], l++) {
            while (r < n - 1 && sum < m) {
                r++;
                sum += arr[r];
            }
 
            if (sum == m)
                cnt++;
        }
 
        System.out.println(cnt);
    }
}
