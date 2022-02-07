/*
    도로 네트워크
    https://www.acmicpc.net/problem/3176

    minCost[a][i]: 노드 a의 2^i 번째 조상까지의 경로 중에 최소 비용
    maxCost[a][i]: 노드 a의 2^i 번째 조상까지의 경로 중에 최대 비용
 */
package Baekjoon.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_3176 {
    private static class Edge {
        int x;
        int cost;

        public Edge(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int logMax;
    private static List<Edge>[] adjList;
    private static int[] depth;
    private static int[][] parent;
    private static int[][] minCost;
    private static int[][] maxCost;
    private static int min;
    private static int max;

    public static void main(String[] args) throws IOException {
        input();
        depth[1] = 0;
        makeTreeByDfs(1);
        fillDpTable();
        System.out.println(getAns());
    }

    private static String getAns() throws IOException {
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            findMinMax(a, b);
            sb.append(min)
                    .append(' ')
                    .append(max)
                    .append('\n');
        }

        return sb.toString();
    }

    private static void findMinMax(int a, int b) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];

        for (int i = 0; diff != 0; i++) {
            if (diff % 2 == 1) {
                calculateMinMax(a, i);
                a = parent[a][i];
            }

            diff >>= 1;
        }

        if (a == b)
            return;

        for (int i = logMax - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                calculateMinMax(a, i);
                a = parent[a][i];

                calculateMinMax(b, i);
                b = parent[b][i];
            }
        }

        calculateMinMax(a, 0);
        a = parent[a][0];

        calculateMinMax(b, 0);
        b = parent[b][0];
    }

    private static void calculateMinMax(int cur, int i) {
        min = Math.min(min, minCost[cur][i]);
        max = Math.max(max, maxCost[cur][i]);
    }

    private static void fillDpTable() {
        for (int j = 1; j < logMax; j++) {
            for (int i = 1; i <= n; i++) {
                if (parent[i][j - 1] == -1)
                    continue;

                int mid = parent[i][j - 1];
                parent[i][j] = parent[mid][j - 1];

                minCost[i][j] = Math.min(minCost[i][j - 1], minCost[mid][j - 1]);
                maxCost[i][j] = Math.max(maxCost[i][j - 1], maxCost[mid][j - 1]);
            }
        }
    }

    private static void makeTreeByDfs(int cur) {
        for (Edge edge : adjList[cur]) {
            int next = edge.x;
            if (depth[next] != -1)
                continue;

            depth[next] = depth[cur] + 1;
            parent[next][0] = cur;

            minCost[next][0] = edge.cost;
            maxCost[next][0] = edge.cost;

            makeTreeByDfs(next);
        }
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        logMax = (int) Math.ceil(Math.log10(n) / Math.log10(2));

        adjList = new List[n + 1];
        for (int i = 0; i <= n; i++)
            adjList[i] = new ArrayList<>();

        depth = new int[n + 1];
        Arrays.fill(depth, -1);

        parent = new int[n + 1][logMax];
        for (int[] arr : parent)
            Arrays.fill(arr, -1);

        minCost = new int[n + 1][logMax];
        for (int[] arr : minCost)
            Arrays.fill(arr, -1);

        maxCost = new int[n + 1][logMax];
        for (int[] arr : maxCost)
            Arrays.fill(arr, -1);

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[a].add(new Edge(b, cost));
            adjList[b].add(new Edge(a, cost));
        }
    }
}