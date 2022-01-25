/**
 * 1767. [SW Test 샘플문제] 프로세서 연결하기
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf&categoryId=AV4suNtaXFEDFAUf&categoryType=CODE&problemTitle=%ED%94%84%EB%A1%9C%EC%84%B8%EC%84%9C+%EC%97%B0%EA%B2%B0%ED%95%98%EA%B8%B0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */
package SWEA._1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    private static class Core {
        int x;
        int y;

        Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[][] board;
    private static List<Core> list;
    private static int ans;
    private static int max;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= TC; tc++) {
            init();
            input();
            getCableLen(0, 0, 0);

            sb.append(String.format("#%d %d\n", tc, ans));
        }

        System.out.println(sb);
    }

    private static void init() {
        ans = Integer.MAX_VALUE;
        max = 0;
        list = new ArrayList<>();
    }

    private static void getCableLen(int idx, int connected, int sum) {
        if (idx == list.size()) {
            if (connected > max) {
                ans = sum;
                max = connected;
            } else if (connected == max)
                ans = Math.min(ans, sum);

            return;
        }

        Core core = list.get(idx);
        int x = core.x;
        int y = core.y;

        if (isAtEdge(x, y))
            getCableLen(idx + 1, connected + 1, sum);
        else {
            int cnt = 0;
            for (int dir = 0; dir < 4; dir++) {
                if (!isPossible(x, y, dir))
                    continue;

                cnt++;
                int val = install(x, y, dir);
                getCableLen(idx + 1, connected + 1, sum + val);
                unInstall(x, y, dir);
            }

            if (cnt == 0)
                getCableLen(idx + 1, connected, sum);
        }
    }

    private static void unInstall(int x, int y, int dir) {
        while (!isAtEdge(x, y)) {
            x += dx[dir];
            y += dy[dir];

            board[x][y] = 0;
        }
    }

    private static int install(int x, int y, int dir) {
        int cnt = 0;
        while (!isAtEdge(x, y)) {
            x += dx[dir];
            y += dy[dir];

            board[x][y] = 1;
            cnt++;
        }

        return cnt;
    }

    private static boolean isPossible(int x, int y, int dir) {
        while (!isAtEdge(x, y)) {
            x += dx[dir];
            y += dy[dir];

            if (board[x][y] == 1)
                return false;
        }

        return true;
    }

    private static boolean isAtEdge(int x, int y) {
        return x == 0 || x == n - 1 || y == 0 || y == n - 1;
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine().trim());
        board = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1)
                    list.add(new Core(i, j));
            }
        }
    }
}