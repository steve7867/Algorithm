/**
 * 정점들의 거리
 * https://www.acmicpc.net/problem/1761
 *
 * 문제 해설: https://entrydeveloper.tistory.com/571
 */
package Baekjoon.LCA._1761._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int max;
    private static int[] depth;
    private static int[][] parent;
    private static int[] dist;
    private static List<Integer>[] adjList;
    private static List<Integer>[] distList;

    public static void main(String[] args) throws IOException {
        input();
        depth[1] = 0;
        dist[1] = 0;
        makeTreeByDfs(1);
        fillDp();
        System.out.println(getAns());
    }

    private static String getAns() throws IOException {
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getDist(a, b)).append('\n');
        }

        return sb.toString();
    }

    private static int getDist(int a, int b) {
        int lca = LCA(a, b);

        return (dist[a] - dist[lca]) + (dist[b] - dist[lca]);
    }


    private static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];

        for (int i = 0; diff != 0 ; i++) {
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

    private static void fillDp() {
        for (int j = 1; j < max; j++) {
            for (int i = 1; i <= n; i++) {
                if (parent[i][j - 1] == -1)
                    continue;

                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }
    }

    private static void makeTreeByDfs(int cur) {
        for (int i = 0; i < adjList[cur].size(); i++) {
            int next = adjList[cur].get(i);

            if (depth[next] != -1)
                continue;

            depth[next] = depth[cur] + 1;
            parent[next][0] = cur;
            dist[next] = dist[cur] + distList[cur].get(i);

            makeTreeByDfs(next);
        }
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        max = (int) Math.ceil(baseLog(2, n));

        depth = new int[n + 1];
        Arrays.fill(depth, -1);

        parent = new int[n + 1][max];
        for (int[] p : parent)
            Arrays.fill(p, -1);

        dist = new int[n + 1];

        adjList = new List[n + 1];
        for (int i = 1; i <= n; i++)
            adjList[i] = new ArrayList<>();

        distList = new List[n + 1];
        for (int i = 1; i <= n; i++)
            distList[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);

            distList[a].add(d);
            distList[b].add(d);
        }
    }

    private static double baseLog(int base, int n) {
        return Math.log(n) / Math.log(base);
    }
}