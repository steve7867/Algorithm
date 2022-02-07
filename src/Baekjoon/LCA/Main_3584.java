/*
    가장 가까운 공통 조상
    https://www.acmicpc.net/problem/3584
 */
package Baekjoon.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_3584 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static final int LOG_MAX = 14;
    private static final int MAX_N = 10001;
    private static final List<Integer>[] childList = new List[MAX_N];
    private static final int[] directParent = new int[MAX_N];
    private static final int[] depth = new int[MAX_N];
    private static final int[][] parent = new int[MAX_N][LOG_MAX];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            input();
            int root = findRoot();
            depth[root] = 0;
            makeTreeByDfs(root);
            fillDpTable();
            sb.append(getAns()).append('\n');
        }

        System.out.println(sb);
    }

    private static int findRoot() {
        for (int i = 1; i <= 10000; i++)
            if (directParent[i] == -1)
                return i;

        return -1;
    }

    private static int getAns() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        return LCA(a, b);
    }

    private static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];

        for (int i = 0; diff != 0; i++) {
            if (diff % 2 == 1) {
                a = parent[a][i];
            }

            diff >>= 1;
        }

        if (a == b)
            return a;

        for (int i = LOG_MAX - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        a = parent[a][0];
        return a;
    }

    private static void fillDpTable() {
        for (int j = 1; j < LOG_MAX; j++) {
            for (int i = 1; i <= n; i++) {
                if (parent[i][j - 1] == -1)
                    continue;

                int mid = parent[i][j - 1];
                parent[i][j] = parent[mid][j - 1];
            }
        }
    }

    private static void makeTreeByDfs(int cur) {
        for (int next : childList[cur]) {
            depth[next] = depth[cur] + 1;
            parent[next][0] = cur;

            makeTreeByDfs(next);
        }
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++)
            childList[i] = new ArrayList<>();

        Arrays.fill(directParent, -1);
        Arrays.fill(depth, -1);

        for (int[] arr : parent)
            Arrays.fill(arr, -1);

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            childList[a].add(b);
            directParent[b] = a;
        }
    }
}