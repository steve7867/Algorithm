package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int r, c;
    private static char[][] board;
    private static int[][] wDist;
    private static int[][] sDist;
    private static final Queue<Pair> wQ = new LinkedList<>();
    private static final Queue<Pair> sQ = new LinkedList<>();

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        input();
        wBfs();
        System.out.println(sBfs());
    }

    private static String sBfs() {
        while (!sQ.isEmpty()) {
            Pair cur = sQ.poll();

            if (board[cur.x][cur.y] == 'D')
                return String.valueOf(sDist[cur.x][cur.y]);

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (OOB(nx, ny))
                    continue;

                if (sDist[nx][ny] >= 0
                        || (wDist[nx][ny] >= 0 && wDist[nx][ny] <= sDist[cur.x][cur.y] + 1 )
                        || board[nx][ny] == 'X')
                    continue;

                sDist[nx][ny] = sDist[cur.x][cur.y] + 1;
                sQ.offer(new Pair(nx, ny));
            }
        }

        return "KAKTUS";
    }

    private static void wBfs() {
        while (!wQ.isEmpty()) {
            Pair cur = wQ.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (OOB(nx, ny))
                    continue;

                if (wDist[nx][ny] >= 0 || board[nx][ny] == 'D' || board[nx][ny] == 'X')
                    continue;

                wDist[nx][ny] = wDist[cur.x][cur.y] + 1;
                wQ.offer(new Pair(nx, ny));
            }
        }
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || x >= r || y < 0 || y >= c;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        wDist = new int[r][c];
        sDist = new int[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(wDist[i], -1);
            Arrays.fill(sDist[i], -1);
        }

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);

                if (board[i][j] == '*') {
                    wQ.offer(new Pair(i, j));
                    wDist[i][j] = 0;
                }

                if (board[i][j] == 'S') {
                    sQ.offer(new Pair(i, j));
                    sDist[i][j] = 0;
                }
            }
        }
    }
}