/**
 * 비숍
 * https://www.acmicpc.net/problem/1799
 *
 * 문제 해설: https://entrydeveloper.tistory.com/225
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_1799 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] board;
    private static int[] ans = new int[2];
    private static boolean[] isUsed1, isUsed2;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        isUsed1 = new boolean[2 * n - 1];
        isUsed2 = new boolean[2 * n - 1];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        func(0, 0, 0, 0);
        func(0, 1, 0, 1);
    
        System.out.println(ans[0] + ans[1]);
    }
    
    private static void func(int x, int y, int cnt, int color) {
        if (y >= n) {
            x++;
            y = y % 2 == 0 ? 1 : 0;
        }
        
        if (x >= n) {
            ans[color] = Math.max(cnt, ans[color]);
            return;
        }
        
        if (board[x][y] == 1 && !isUsed1[x + y] && !isUsed2[x - y + n - 1]) {
            isUsed1[x + y] = isUsed2[x - y + n - 1] = true;
            func(x, y + 2, cnt + 1, color);
            isUsed1[x + y] = isUsed2[x - y + n - 1] = false;
        }
        func(x, y + 2, cnt, color);
    }
}