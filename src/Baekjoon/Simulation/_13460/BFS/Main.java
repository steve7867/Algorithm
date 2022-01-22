/**
 * 구슬 탈출 2
 * https://www.acmicpc.net/problem/13460
 */
package Baekjoon.Simulation._13460.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
    static int n, m;
    static char[][] board;
    static int[][][][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        dist = new int[n][m][n][m];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    Arrays.fill(dist[i][j][k], -1);
                }
            }
        }
 
        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = input.charAt(j);
                board[i][j] = c;
 
                if (c == 'R') {
                    rx = i;
                    ry = j;
                }
 
                if (c == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
 
        Queue<int[]> q = new LinkedList<>();
 
        dist[rx][ry][bx][by] = 0;
        q.offer(new int[]{rx, ry, bx, by});
 
        while (!q.isEmpty()) {
            int[] cur = q.poll();
 
 
            if (dist[cur[0]][cur[1]][cur[2]][cur[3]] >= 10)
                break;
 
            for (int dir = 0; dir < 4; dir++) {
                rx = cur[0];
                ry = cur[1];
                bx = cur[2];
                by = cur[3];
 
                while (true) {
                    bx += dx[dir];
                    by += dy[dir];
                    if (board[bx][by] == '#') {
                        bx -= dx[dir];
                        by -= dy[dir];
                        break;
                    }
 
                    if (board[bx][by] == 'O')
                        break;
                }
 
                if (board[bx][by] == 'O')
                    continue;
 
                while (true) {
                    rx += dx[dir];
                    ry += dy[dir];
                    if (board[rx][ry] == '#') {
                        rx -= dx[dir];
                        ry -= dy[dir];
                        break;
                    }
 
                    if (board[rx][ry] == 'O')
                        break;
                }
 
                if (board[rx][ry] == 'O') {
                    System.out.println(dist[cur[0]][cur[1]][cur[2]][cur[3]] + 1);
                    return;
                }
 
                if (rx == bx && ry == by) {
                    switch (dir) {
                        case 0:
                            if (cur[0] > cur[2])
                                bx--;
                            else
                                rx--;
                            break;
                        case 1:
                            if (cur[0] < cur[2])
                                bx++;
                            else
                                rx++;
                            break;
                        case 2:
                            if (cur[1] > cur[3])
                                by--;
                            else
                                ry--;
                            break;
                        case 3:
                            if (cur[1] < cur[3])
                                by++;
                            else
                                ry++;
                            break;
                    }
                }
 
                if (dist[rx][ry][bx][by] >= 0)
                    continue;
 
                dist[rx][ry][bx][by] = dist[cur[0]][cur[1]][cur[2]][cur[3]] + 1;
                q.offer(new int[]{rx, ry, bx, by});
            }
        }
 
        System.out.println(-1);
    }
}