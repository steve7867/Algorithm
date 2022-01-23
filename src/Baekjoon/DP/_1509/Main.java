/**
 * 팰린드롬 분할
 * https://www.acmicpc.net/problem/1509
 */
package Baekjoon.DP._1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    private static int n;
    private static int[] dp;
    private static boolean[][] isPalindrome;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] ch = s.toCharArray();
        n = s.length();
 
        dp = new int[n];
        Arrays.fill(dp, -1);
 
        isPalindrome = new boolean[n][n];
        makePalindromeTable(ch, isPalindrome);
 
        System.out.println(getMin(0));
    }
 
    private static void makePalindromeTable(char[] ch, boolean[][] isPalindrome) {
        int n = ch.length;
 
        for (int i = 0; i < n; i++)
            isPalindrome[i][i] = true;
 
        for (int i = 0; i < n - 1; i++) {
            if (ch[i] == ch[i + 1])
                isPalindrome[i][i + 1] = true;
        }
 
        for (int i = 2; i < n; i++)
            for (int j = 0; j < n - i; j++)
                if (ch[j] == ch[j + i] && isPalindrome[j + 1][j + i - 1])
                    isPalindrome[j][j + i] = true;
    }
 
    private static int getMin(int st) {
        if (st == n)
            return 0;
 
        if (dp[st] > 0)
            return dp[st];
        
        int min = Integer.MAX_VALUE;
        for (int i = st; i < n; i++) {
            if (isPalindrome[st][i]) {
                min = Math.min(min, 1 + getMin(i + 1));
            }
        }
 
        return dp[st] = min;
    }
 
}
