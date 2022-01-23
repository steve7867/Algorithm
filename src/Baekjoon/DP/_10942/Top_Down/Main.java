/**
 * 팰린드롬?
 * https://www.acmicpc.net/problem/10942
 */
package Baekjoon.DP._10942.Top_Down;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] arr;
    private static int[][] dp;
 
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(getAnswer());
    }
 
    private static String getAnswer() throws IOException {
        StringBuilder sb = new StringBuilder();
        int m = stoi(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            sb.append(isPalindrome(a, b)).append('\n');
        }
 
        return sb.toString();
    }
 
    private static int isPalindrome(int a, int b) {
        if (dp[a][b] >= 0)
            return dp[a][b];
 
        if (a == b)
            return dp[a][b] = 1;
 
        if (a + 1 == b) {
            if (arr[a] == arr[b])
                return dp[a][b] = 1;
            else
                return dp[a][b] = 0;
        }
 
        if (arr[a] == arr[b] && isPalindrome(a + 1, b - 1) == 1)
            return dp[a][b] = 1;
        else
            return dp[a][b] = 0;
    }
 
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
 
    private static void input() throws IOException {
        n = stoi(br.readLine());
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = stoi(st.nextToken());
 
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            Arrays.fill(dp[i] , -1);
    }
}