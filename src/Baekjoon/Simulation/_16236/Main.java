/**
 * 아기 상어
 * https://www.acmicpc.net/problem/16236
 */
package Baekjoon.Simulation._16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
    static int n;
    static int[][] board;
    static int size = 2;
    static int eat = 0;
    static int curX;
    static int curY;
    static int ans;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    curX = i;
                    curY = j;
                    board[i][j] = 0;
                }
            }
        }
 
        while (true) {
            if (bfs()) {
                continue;
            } else {
                System.out.println(ans);
                return;
            }
        }
    }
 
    private static boolean bfs() {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);
 
        Queue<int[]> q = new LinkedList<>();
        dist[curX][curY] = 0;
        q.offer(new int[]{curX, curY});
 
        while (!q.isEmpty()) {
            int[] cur = q.poll();
 
            if (isEatable(cur)) {
                for (int[] pos : q) {
                    if (dist[pos[0]][pos[1]] > dist[cur[0]][cur[1]])
                        break;
 
                    // 사이즈가 안 맞으면
                    if (!isEatable(pos))
                        continue;
 
                    // 더 위쪽에 있으면
                    if (pos[0] < cur[0]) {
                        cur = pos;
                        continue;
                    }
 
                    // 더 왼쪽에 있으면
                    if (pos[0] == cur[0] && pos[1] < cur[1]) {
                        cur = pos;
                        continue;
                    }
                }
 
                ans += dist[cur[0]][cur[1]];
                board[cur[0]][cur[1]] = 0;
                eat++;
                if (eat == size) {
                    size++;
                    eat = 0;
                }
                curX = cur[0];
                curY = cur[1];
                return true;
            }
 
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
 
                if (OOB(nx, ny))
                    continue;
 
                if (dist[nx][ny] >= 0 || board[nx][ny] > size)
                    continue;
 
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
 
        }
 
        return false;
    }
 
    private static boolean isEatable(int[] pos) {
        return board[pos[0]][pos[1]] > 0 && board[pos[0]][pos[1]] < size;
    }
 
    private static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= n;
    }
}
