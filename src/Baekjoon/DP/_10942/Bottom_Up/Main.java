/**
 * 팰린드롬?
 * https://www.acmicpc.net/problem/10942
 */
package Baekjoon.DP._10942.Bottom_Up;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws IOException {
        int[] arr = input();
        int n = arr.length - 1;
 
        boolean[][] isPalindrome = makeDpTable(n, arr);
 
        System.out.println(getAnswer(isPalindrome));
    }
 
    private static String getAnswer(boolean[][] isPalindrome) throws IOException {
        StringBuilder sb = new StringBuilder();
        int m = stoi(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            sb.append(isPalindrome[a][b] ? 1 : 0).append('\n');
        }
 
        return sb.toString();
    }
 
    private static boolean[][] makeDpTable(int n, int[] arr) {
        boolean[][] dp = new boolean[n + 1][n + 1];
 
        for (int i = 1; i <= n; i++)
            dp[i][i] = true;
 
        for (int i = 2; i <= n; i++) {
            if (arr[i - 1] == arr[i])
                dp[i - 1][i] = true;
        }
 
        for (int i = 2; i <= n - 1; i++) { // i: 구간 길이
            for (int j = 0; j <= n - i; j++) { // j: 시작점
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }
 
        return dp;
    }
 
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
 
    private static int[] input() throws IOException {
        int n = stoi(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = stoi(st.nextToken());
 
        return arr;
    }
}
