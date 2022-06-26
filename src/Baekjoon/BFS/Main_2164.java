package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2164 {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n;
    private static int[][] board;
    private static int[][] island;
    private static final Queue<Pair> q = new LinkedList<>();

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        input();
        mark();
        System.out.println(bfs());
    }

    private static void mark() {
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 && island[i][j] == 0) {
                    mark(i, j, num);
                    num++;
                }
            }
        }
    }

    private static void mark(int x, int y, int num) {
        Queue<Pair> q = new LinkedList<>();

        island[x][y] = num;
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (OOB(nx, ny))
                    continue;

                if (board[nx][ny] == -1 || island[nx][ny] > 0)
                    continue;

                island[nx][ny] = num;
                q.offer(new Pair(nx, ny));
            }
        }

    }

    private static int bfs() {
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (OOB(nx, ny))
                    continue;

                if (island[cur.x][cur.y] == island[nx][ny])
                    continue;

                if (island[cur.x][cur.y] != 0 && island[nx][ny] != 0) {
                    ans = Math.min(board[cur.x][cur.y] + board[nx][ny], ans);
                    continue;
                }

                board[nx][ny] = board[cur.x][cur.y] + 1;
                island[nx][ny] = island[cur.x][cur.y];
                q.offer(new Pair(nx, ny));
            }
        }

        return ans;
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) - 1;

                if (board[i][j] == 0)
                    q.offer(new Pair(i, j));
            }
        }

        island = new int[n][n];
    }
}