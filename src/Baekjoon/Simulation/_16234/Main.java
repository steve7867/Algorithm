/**
 * 인구 이동
 * https://www.acmicpc.net/problem/16234
 */
package Baekjoon.Simulation._16234;

import java.io.*;
import java.util.*;
 
public class Main {
    private static int[][] a;
    private static boolean[][] visited;
    private static int n, l, r;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
 
        a = new int[n][n];
        visited = new boolean[n][n];
 
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(input[j]);
            }
        }
 
        int day = 0;
        while (true) {
            for (int i = 0; i < n; i++)
                Arrays.fill(visited[i], false);
 
            int cnt = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (!visited[x][y]) {
                        if (bfs(x, y))
                            cnt++;
                    }
                }
            }
 
            if (cnt > 0)
                day++;
            else
                break;
        }
 
        System.out.println(day);
    }
 
    private static boolean OOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
 
    private static boolean bfs(int x, int y) {
        Queue<Pair> history = new LinkedList<>();
        Queue<Pair> q = new LinkedList<>();
 
        visited[x][y] = true;
        q.offer(new Pair(x, y));
 
        int sum = 0;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            sum += a[cur.x][cur.y];
            history.offer(cur);
 
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
 
                if (OOB(nx, ny) || visited[nx][ny])
                    continue;
 
                int diff = Math.abs(a[cur.x][cur.y] - a[nx][ny]);
                if (l <= diff && diff <= r) {
                    visited[nx][ny] = true;
                    q.offer(new Pair(nx, ny));
                }
            }
        }
 
        int avg = sum / history.size();
        for (Pair p : history)
            a[p.x][p.y] = avg;
 
        return history.size() > 1;
    }
}
 
class Pair {
    int x, y;
 
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}