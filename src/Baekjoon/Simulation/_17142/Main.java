/**
 * 연구소 3
 * https://www.acmicpc.net/problem/17142
 */
package Baekjoon.Simulation._17142;

import java.io.*;
import java.util.*;
 
public class Main {
    private static int n, m;
    private static int[][] board;
    private static List<Pair> virus = new ArrayList<>();
    private static List<Pair> list = new ArrayList<>();
    private static int ans = -1;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
 
                if (board[i][j] == 2)
                    virus.add(new Pair(i, j));
            }
        }
 
        backtrack(0, 0);
        System.out.println(ans);
    }
 
    private static void backtrack(int num, int i) {
        if (num == m) {
            int result = bfs();
 
            if (result != -1)
                ans = (ans == -1) ? result : Math.min(ans, result);
 
            return;
        }
 
        if (i == virus.size())
            return;
 
        list.add(virus.get(i));
        backtrack(num + 1, i + 1);
        list.remove(list.size() - 1);
 
        backtrack(num, i + 1);
    }
 
    private static int bfs() {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);
 
        Queue<Pair> q = new LinkedList<>();
        for (Pair p : list) {
            q.offer(p);
            dist[p.x][p.y] = 0;
        }
 
        while (!q.isEmpty()) {
            Pair cur = q.poll();
 
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
 
                if (OOB(nx, ny))
                    continue;
 
                if (board[nx][ny] == 1 || dist[nx][ny] >= 0)
                    continue;
 
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
 
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[i][j] == 0 || board[i][j] == 2) && dist[i][j] == -1)
                    return -1;
 
                if (board[i][j] == 2)
                    continue;
 
                if (dist[i][j] > max)
                    max = dist[i][j];
            }
        }
 
        return max;
    }
 
    private static boolean OOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}
 
class Pair {
    int x;
    int y;
 
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}