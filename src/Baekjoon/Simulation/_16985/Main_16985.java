/**
 * Maaaaaaaaaze
 * https://www.acmicpc.net/problem/16985
 */
package Baekjoon.Simulation._16985;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_16985 {
    private static int[][][] board = new int[5][5][5];
    private static int ans = -1;
    private static Queue<Tuple> q = new LinkedList<>();
    private static int[][][] dist = new int[5][5][5];
    private static boolean[] visited = new boolean[5];
    private static int[] dz = {1, -1, 0, 0, 0, 0};
    private static int[] dx = {0, 0, 1, -1, 0, 0};
    private static int[] dy = {0, 0, 0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        for (int z = 0; z < 5; z++) {
            for (int x = 0; x < 5; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < 5; y++)
                    board[z][x][y] = Integer.parseInt(st.nextToken());
            }
        }
 
        backtrack(0, new int[5][5][5]);
        System.out.println(ans);
    }
 
    private static void backtrack(int floor, int[][][] maze) {
        if (floor == 5) {
            if (ans == 12) // 12는 최적해, 이미 최적해에 도달한 경우 더 진행할 필요X
                return;
 
            int result = bfs(maze, new Tuple(0, 0, 0), new Tuple(4, 4, 4));
            if (result != -1)
                ans = (ans == -1) ? result : Math.min(ans, result);
 
            return;
        }
 
        for (int i = 0; i < 5; i++) {
            if (visited[i])
                continue;
 
            visited[i] = true;
            for (int r = 0; r < 4; r++) {
                rotate(board[i], maze[floor], r);
                backtrack(floor + 1, maze);
            }
            visited[i] = false;
        }
    }
 
    private static int bfs(int[][][] maze, Tuple src, Tuple dest) {
        if (maze[src.z][src.x][src.y] == 0 || maze[dest.z][dest.x][dest.y] == 0)
            return -1;
 
        for (int z = 0; z < 5; z++) {
            for (int x = 0; x < 5; x++)
                Arrays.fill(dist[z][x], -1);
        }
 
        q.clear();
 
        dist[src.z][src.x][src.y] = 0;
        q.offer(src);
 
        while (!q.isEmpty()) {
            Tuple cur = q.poll();
 
            if (cur.z == dest.z && cur.x == dest.x && cur.y == dest.y)
                return dist[cur.z][cur.x][cur.y];
 
            for (int dir = 0; dir < 6; dir++) {
                int nz = cur.z + dz[dir];
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
 
                if (OOB(nz, nx, ny))
                    continue;
 
                if (dist[nz][nx][ny] >= 0 || maze[nz][nx][ny] == 0)
                    continue;
 
                dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
                q.offer(new Tuple(nz, nx, ny));
            }
        }
 
        return -1;
    }
 
    private static boolean OOB(int z, int x, int y) {
        return z < 0 || z >= 5 || x < 0 || x >= 5 || y < 0 || y >= 5;
    }
 
    private static void rotate(int[][] board, int[][] maze, int r) {
        if (r == 0) {
            for (int i = 0; i < 5; i++)
                System.arraycopy(board[i], 0, maze[i], 0, 5);
        } else if (r == 1) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++)
                    maze[j][4 - i] = board[i][j];
            }
        } else if (r == 2) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++)
                    maze[4 - j][i] = board[i][j];
            }
        } else if (r == 3) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++)
                    maze[4 - i][4 - j] = board[i][j];
            }
        }
    }
}
 
class Tuple {
    int z;
    int x;
    int y;
 
    Tuple(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}