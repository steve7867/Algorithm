package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1525 {

    static class State {
        int[][] puzzle;
        int dist;
        int x;
        int y;

        public State(int[][] puzzle, int dist, int x, int y) {
            this.puzzle = puzzle;
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }

    private static final Queue<State> q = new LinkedList<>();
    private static final Set<Integer> set = new HashSet<>();

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs());
    }

    private static int bfs() {
        while (!q.isEmpty()) {
            State cur = q.poll();

            int[][] puzzle = cur.puzzle;
            int dist = cur.dist;
            int x = cur.x;
            int y = cur.y;

            if (done(puzzle))
                return dist;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (OOB(nx, ny))
                    continue;

                int[][] next = getNext(puzzle, nx, ny, x, y);
                int hashcode = hashcode(next);
                if (set.contains(hashcode))
                    continue;

                set.add(hashcode);
                q.offer(new State(next, dist + 1, nx, ny));
            }
        }

        return -1;
    }

    private static boolean done(int[][] puzzle) {
        return hashcode(puzzle) == 87654321;
    }

    private static int[][] getNext(int[][] puzzle, int nx, int ny, int x, int y) {
        int[][] next = new int[3][3];

        for (int i = 0; i < 3; i++)
            System.arraycopy(puzzle[i], 0, next[i], 0, 3);

        int a = next[nx][ny];
        next[nx][ny] = next[x][y];
        next[x][y] = a;

        return next;
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || x >= 3 || y < 0 || y >= 3;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] puzzle = new int[3][3];
        int x = 0, y = 0;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                puzzle[i][j] = Integer.parseInt(st.nextToken());

                if (puzzle[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }

        State state = new State(puzzle, 0, x, y);
        int hashcode = hashcode(puzzle);
        set.add(hashcode);
        q.offer(state);
    }

    private static int hashcode(int[][] puzzle) {
        int ret = 0;

        int m = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ret += puzzle[i][j] * m;
                m *= 10;
            }
        }

        return ret;
    }
}