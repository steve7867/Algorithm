package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1039 {

    private static int r, c;
    private static char[][] board;
    private static final Queue<Pair> fireQ = new LinkedList<>();
    private static final Queue<Pair> jQ = new LinkedList<>();
    private static int[][] fDist;
    private static int[][] jDist;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        input();
        fireBfs();
        jBfs();
    }

    private static void jBfs() {
        while (!jQ.isEmpty()) {
            Pair cur = jQ.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (OOB(nx, ny)) {
                    System.out.println(jDist[cur.x][cur.y] + 1);
                    return;
                }

                if (jDist[nx][ny] != -1 || board[nx][ny] == '#')
                    continue;

                if (fDist[nx][ny] != -1 && fDist[nx][ny] <= jDist[cur.x][cur.y] + 1)
                    continue;

                jDist[nx][ny] = jDist[cur.x][cur.y] + 1;
                jQ.offer(new Pair(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static void fireBfs() {
        while (!fireQ.isEmpty()) {
            Pair cur = fireQ.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (OOB(nx, ny))
                    continue;

                if (fDist[nx][ny] != -1 || board[nx][ny] == '#')
                    continue;

                fDist[nx][ny] = fDist[cur.x][cur.y] + 1;
                fireQ.offer(new Pair(nx, ny));
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
        fDist = new int[r][c];
        jDist = new int[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(fDist[i], -1);
            Arrays.fill(jDist[i], -1);
        }

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = s.charAt(j);

                if (board[i][j] == 'F') {
                    fireQ.offer(new Pair(i, j));
                    fDist[i][j] = 0;
                }

                if (board[i][j] == 'J') {
                    jQ.offer(new Pair(i, j));
                    jDist[i][j] = 0;
                }
            }
        }

    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}