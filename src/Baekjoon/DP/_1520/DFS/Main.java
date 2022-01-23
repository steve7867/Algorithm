/**
 * 내리막 길
 * https://www.acmicpc.net/problem/1520
 */
package Baekjoon.DP._1520.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
 
    private static int n;
    private static int m;
    private static int[][] board;
    private static int[][] dp;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dfs(0, 0));
    }
 
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
 
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                board[i][j] = stoi(st.nextToken());
        }
 
        dp = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i] , -1);
    }
 
    private static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1)
            return 1;
 
        if (dp[x][y] >= 0)
            return dp[x][y];
 
        int ret = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
 
            if (OOB(nx, ny) || board[x][y] <= board[nx][ny])
                continue;
 
            ret += dfs(nx, ny);
        }
 
        return dp[x][y] = ret;
    }
 
    private static boolean OOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
 
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
