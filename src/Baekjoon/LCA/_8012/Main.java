/*
    한동이는 영업사원!
    https://www.acmicpc.net/problem/8012
 */
package Baekjoon.LCA._8012;

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
        int ans = getAns();
        System.out.println(ans);
    }

    private static int getAns() throws IOException {
        int ans = 0;
        int m = Integer.parseInt(br.readLine());

        int src = Integer.parseInt(br.readLine());
        for (int i = 0; i < m - 1; i++) {
            int dest = Integer.parseInt(br.readLine());

            ans += LCA(src, dest);

            src = dest;
        }

        return ans;
    }

    private static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];
        int aDist = diff;

        for (int i = 0; diff != 0; i++) {
            if (diff % 2 == 1)
                a = parent[a][i];

            diff >>= 1;
        }

        int bDist = 0;
        if (a != b) {
            for (int i = MAX - 1; i >= 0; i--) {
                if (parent[a][i] != parent[b][i]) {
                    a = parent[a][i];
                    b = parent[b][i];

                    aDist += 1 << i;
                    bDist += 1 << i;
                }
            }

            aDist++;
            bDist++;
        }

        return aDist + bDist;
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