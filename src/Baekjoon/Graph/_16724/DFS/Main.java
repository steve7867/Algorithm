/**
 * 피리 부는 사나이
 * https://www.acmicpc.net/problem/16724
 *
 * 문제 해설: https://entrydeveloper.tistory.com/575
 */
package Baekjoon.Graph._16724.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][] board;
    private static int n, m;
    private static boolean[][] visited;
    private static boolean[][] finished;
    private static final Map<Character, Integer> dirMap = new HashMap<>();
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int ans = 0;

    static {
        dirMap.put('U', 0);
        dirMap.put('D', 1);
        dirMap.put('L', 2);
        dirMap.put('R', 3);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
        System.out.println(ans);
    }

    private static void process() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!visited[i][j])
                    dfs(i, j);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int dir = dirMap.get(board[x][y]);

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (visited[nx][ny]) {
            if (!finished[nx][ny]) // 싸이클 지점
                ans++;

            finished[x][y] = true;
            return;
        } else
            dfs(nx, ny);

        finished[x][y] = true;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++)
                board[i][j] = s.charAt(j);
        }

        visited = new boolean[n][m];
        finished = new boolean[n][m];
    }
}