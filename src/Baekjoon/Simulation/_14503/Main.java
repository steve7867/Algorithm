/**
 * 로봇 청소기
 * https://www.acmicpc.net/problem/14503
 */
package Baekjoon.Simulation._14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
    static final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북동남서
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        int[][] board = new int[n][m];
        boolean[][] cleared = new boolean[n][m];
 
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
 
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
 
        int ans = 0;
        while (true) {
            if (!cleared[x][y]) {
                cleared[x][y] = true;
                ans++;
            }
 
            boolean find = false;
            for (int i = 0; i < 4; i++) {
                int check = dir - 1;
                if (check == -1)
                    check = 3;
 
                int checkX = x + d[check][0];
                int checkY = y + d[check][1];
 
                if (board[checkX][checkY] == 1 || cleared[checkX][checkY]) {
                    dir = check;
                    continue;
                }
 
                find = true;
                dir = check;
                x = checkX;
                y = checkY;
                break;
            }
 
            if (!find) {
                int backDir = 0;
                if (dir == 0 || dir == 1)
                    backDir = dir + 2;
                else if (dir == 2)
                    backDir = 0;
                else if (dir == 3)
                    backDir = 1;
 
                int checkX = x + d[backDir][0];
                int checkY = y + d[backDir][1];
                if (board[checkX][checkY] == 1) {
                    System.out.println(ans);
                    return;
                }
                x = checkX;
                y = checkY;
            }
        }
 
    }
}
