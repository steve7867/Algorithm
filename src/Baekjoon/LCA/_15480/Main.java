/*
    LCA와 쿼리
    https://www.acmicpc.net/problem/15480

    LCA(u, v), LCA(r, u), LCA(r, v) 중에서 깊이가 가장 깊은 노드가 정답.

    문제 해설: https://entrydeveloper.tistory.com/581
 */
package Baekjoon.LCA._15480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int MAX;
    private static List<Integer>[] adjList;
    private static int[] depth;
    private static int[][] parent;

    public static void main(String[] args) throws IOException {
        input();
        depth[1] = 0;
        makeTreeByDfs(1);
        fillDpTable();
        System.out.println(getAns());
    }

    private static String getAns() throws IOException {
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(query(r, u, v)).append('\n');
        }

        return sb.toString();
    }

    private static int query(int r, int u, int v) {
        int lca1 = LCA(u, v);
        int lca2 = LCA(r, u);
        int lca3 = LCA(r, v);

        int ret = lca1;
        if (depth[lca2] > depth[ret])
            ret = lca2;
        if (depth[lca3] > depth[ret])
            ret = lca3;

        return ret;
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

            diff >>= 1;
        }

        if (a != b) {
            for (int i = MAX - 1; i >= 0; i--) {
                if (parent[a][i] != parent[b][i]) {
                    a = parent[a][i];
                    b = parent[b][i];
                }
            }

            a = parent[a][0];
        }

        return a;
    }

    private static void fillDpTable() {
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

            depth[next] = depth[cur] + 1;
            parent[next][0] = cur;

            makeTreeByDfs(next);
        }
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        MAX = (int) Math.ceil(Math.log10(n) / Math.log10(2));

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

        depth = new int[n + 1];
        Arrays.fill(depth, -1);

        parent = new int[n + 1][MAX];
        for (int[] arr : parent)
            Arrays.fill(arr, -1);
    }
}