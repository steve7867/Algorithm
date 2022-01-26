/**
 * LCA 2
 * https://www.acmicpc.net/problem/11438
 *
 * 최소 공통 조상 기본 문제
 */
package Baekjoon.LCA._11438;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
    private static int MAX;
    private static int[][] parent;
    private static int[] depth;
    private static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        input();
        depth[1] = 0;
        makeTreeByDfs(1);
        fillDP();
        bw.write(getAns());

        br.close();
        bw.close();
    }

    private static String getAns() throws IOException {
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a, b)).append('\n');
        }

        return sb.toString();
    }

    private static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];

        for (int i = 0; diff != 0; i++) {
            if (diff % 2 == 1)
                a = parent[a][i];

            diff = diff >> 1;
        }

        if (a != b) {
            for (int i = MAX - 1; i >= 0; i--) {
                if (parent[a][i] != -1 && parent[a][i] != parent[b][i]) {
                    a = parent[a][i];
                    b = parent[b][i];
                }
            }

            a = parent[a][0];
        }

        return a;
    }

    private static void fillDP() {
        for (int j = 1; j < MAX; j++) {
            for (int i = 1; i <= n; i++) {
                if (parent[i][j - 1] == -1)
                    continue;

                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }
    }

    private static void makeTreeByDfs(int cur) {
        for (int next : adjList[cur]) {
            if (depth[next] != -1)
                continue;

            parent[next][0] = cur;
            depth[next] = depth[cur] + 1;
            makeTreeByDfs(next);
        }
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        MAX = (int) Math.ceil(baseLog(2, n));

        parent = new int[n + 1][MAX];
        for (int[] p : parent)
            Arrays.fill(p , -1);

        depth = new int[n + 1];
        Arrays.fill(depth, -1);

        adjList = new List[n + 1];
        for (int i = 1; i <= n; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }
    }

    public static double baseLog(int base, int n) {
        return Math.log(n) / Math.log(base);
    }
}