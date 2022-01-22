/**
 * 연구소 2
 * https://www.acmicpc.net/problem/17141
 */
package Baekjoon.Simulation._17141;

import java.io.*;
import java.util.*;
 
public class Main {
    private static int N;
    private static int M;
    private static int[][] board;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static List<Pair> list = new ArrayList<>();
    private static List<Pair> temp = new ArrayList<>();
    private static int ans = -1;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
 
        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
                if (board[x][y] == 2)
                    list.add(new Pair(x, y));
            }
        }
 
        combi(0);
 
        System.out.println(ans);
    }
 
    private static void combi(int i) {
        if (temp.size() == M) {
            int result = bfs();
            if (result >= 0)
                ans = (ans == -1) ? result : Math.min(ans, result);
            return;
        }
 
        if (i == list.size())
            return;
 
        temp.add(list.get(i));
        combi(i + 1);
        temp.remove(temp.size() - 1);
 
        combi(i + 1);
    }
 
    private static int bfs() {
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(dist[i], -1);
 
        for (Pair p : temp) {
            dist[p.x][p.y] = 0;
            q.offer(p);
        }
 
        while (!q.isEmpty()) {
            Pair cur = q.poll();
 
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
 
                if (OOB(nx, ny))
                    continue;
 
                if (dist[nx][ny] >= 0 || board[nx][ny] == 1)
                    continue;
 
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
 
        int ret = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (board[x][y] == 0 && dist[x][y] == -1)
                    return -1;
 
                if (board[x][y] == 0 || board[x][y] == 2)
                    ret = Math.max(ret, dist[x][y]);
            }
        }
 
        return ret;
    }
 
    private static boolean OOB(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
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