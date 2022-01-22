/**
 * 퇴사
 * https://www.acmicpc.net/problem/14501
 */
package Baekjoon.Backtracking._14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int n;
    static int[] day;
    static int[] pay;
    static int ans = 0;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        day = new int[n];
        pay = new int[n];
 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }
 
        backtrack(0, 0);
        System.out.println(ans);
    }
 
    private static void backtrack(int idx, int paySum) {
        if (idx == n) {
            ans = Math.max(ans, paySum);
            return;
        }
 
        //choose
        if (idx + day[idx] <= n)
            backtrack(idx + day[idx], paySum + pay[idx]);
 
        //not choose
        backtrack(idx + 1, paySum);
    }
}