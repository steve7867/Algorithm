/**
 * 피리 부는 사나이
 * https://www.acmicpc.net/problem/16724
 *
 * 문제 해설: https://entrydeveloper.tistory.com/575
 */
package Baekjoon.Graph._16724.UnionFind;

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
    private static int[] p;
    private static boolean[] visited;
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = convert(i, j);
                if (!visited[cur])
                    search(cur);
            }
        }
    }

    private static int convert(int x, int y) {
        return x * m + y;
    }

    private static int getNext(int cur) {
        int x = cur / m;
        int y = cur % m;

        int dir = dirMap.get(board[x][y]);

        return convert(x + dx[dir], y + dy[dir]);
    }

    private static void search(int cur) {
        while (true) {
            visited[cur] = true;
            int next = getNext(cur);

            if (!visited[next]) {
                union(cur, next);
                cur = next;
            } else if (find(next) == cur) { // 싸이클 지점
                ans++;
                break;
            } else { // next가 다른 싸이클에 속한 경우
                union(cur, next);
                break;
            }
        }
    }

    private static int find(int i) {
        if (p[i] != i)
            p[i] = find(p[i]);

        return p[i];
    }

    //a를 b에다 붙힘
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        p[a] = b;
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

        visited = new boolean[n * m];
        p = new int[n * m];
        for (int i = 0; i < p.length; i++)
            p[i] = i;
    }
}