/*
    공통조상
    https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15PTkqAPYCFAYD
 */
package SWEA._1248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static class List {
        int[] arr;
        int size;

        public List() {
            arr = new int[]{-1, -1};
            size = 0;
        }

        public void add(int item) {
            arr[size++] = item;
        }

        public void clear() {
            arr[0] = arr[1] = -1;
            size = 0;
        }
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int maxN = 10000;
    private static final int max = 14;
    private static final List[] childList = new List[maxN + 1];
    private static final int[] depth = new int[maxN + 1];
    private static final int[][] parent = new int[maxN + 1][max];
    private static final int[] stack = new int[maxN];
    private static int top = -1;
    private static int V, E, a, b;

    static {
        for (int i = 0; i <= maxN; i++)
            childList[i] = new List();
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            init();
            input();
            makeTreeByDfs();
            fillDp();
            int lca = getLCA(a, b);
            int res = DFS(lca);

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(lca)
                    .append(' ')
                    .append(res)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static int DFS(int start) {
        int cnt = 0;

        stack[++top] = start;
        while (top != -1) {
            int cur = stack[top--];
            cnt++;

            for (int next : childList[cur].arr) {
                if (next == -1)
                    continue;

                stack[++top] = next;
            }
        }

        return cnt;
    }

    private static int getLCA(int a, int b) {
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
            for (int i = max - 1; i >= 0; i--) {
                if (parent[a][i] != -1 && parent[a][i] != parent[b][i]) {
                    a = parent[a][i];
                    b = parent[b][i];
                }

            }
            a = parent[a][0];
        }

        return a;
    }

    private static void init() {
        for (int i = 0; i <= maxN; i++)
            childList[i].clear();

        for (int i = 0; i < parent.length; i++)
            for (int j = 0; j < max; j++)
                parent[i][j] = -1;
    }

    private static void fillDp() {
        for (int j = 1; j < max; j++) {
            for (int i = 1; i <= V; i++) {
                if (parent[i][j - 1] == -1)
                    continue;

                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }
    }

    private static void makeTreeByDfs() {
        stack[++top] = 1;
        depth[1] = 0;

        while (top != -1) {
            int cur = stack[top--];

            for (int next : childList[cur].arr) {
                if (next == -1)
                    continue;

                depth[next] = depth[cur] + 1;
                parent[next][0] = cur;

                stack[++top] = next;
            }
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < E; j++) {
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            childList[u].add(v);
        }
    }

}