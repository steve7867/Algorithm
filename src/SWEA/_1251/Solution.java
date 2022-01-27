/**
 * 하나로
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD&categoryId=AV15StKqAQkCFAYD&categoryType=CODE&problemTitle=%ED%95%98%EB%82%98%EB%A1%9C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */
package SWEA._1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static class Edge {
        int u;
        int v;
        double cost;

        public Edge(int u, int v, double cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static double E;
    private static final long[][] vertices = new long[1000][2];
    private static final int edgeMax = (1000 * 999) / 2;
    private static final Edge[] edges = new Edge[edgeMax];
    private static final Edge[] temp = new Edge[edgeMax];
    private static final int[] p = new int[1000];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            input();
            init();
            fillEdgeTable();

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(getAns())
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void init() {
        for (int i = 0; i < n; i++)
            p[i] = i;
    }

    private static long getAns() {
        double totalCost = 0;

        int cnt = 0;
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            double cost = edge.cost;

            if (find(u) != find(v)) {
                totalCost += cost;
                union(u, v);
                cnt++;
                if (cnt == n - 1)
                    break;
            }
        }

        return Math.round(totalCost);
    }

    private static int find(int i) {
        if (i != p[i])
            p[i] = find(p[i]);

        return p[i];
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        p[b] = a;
    }

    private static void fillEdgeTable() {
        int k = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                edges[k++] = new Edge(i, j, getCost(i, j));

        mergeSort(0, k);
    }

    private static void mergeSort(int st, int en) {
        if (st == en - 1)
            return;

        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid, en);

        System.arraycopy(edges, st, temp, st, en - st);

        int aIdx = st;
        int bIdx = mid;
        int cur = st;

        while (cur < en) {
            if (aIdx == mid)
                edges[cur++] = temp[bIdx++];
            else if (bIdx == en)
                edges[cur++] = temp[aIdx++];
            else if (temp[aIdx].cost <= temp[bIdx].cost)
                edges[cur++] = temp[aIdx++];
            else
                edges[cur++] = temp[bIdx++];
        }
    }

    private static double getCost(int a, int b) {
        long dist1 = vertices[a][0] - vertices[b][0];
        long dist2 = vertices[a][1] - vertices[b][1];

        return (dist1 * dist1 + dist2 * dist2) * E;
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        StringTokenizer stX = new StringTokenizer(br.readLine());
        StringTokenizer stY = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            vertices[i][0] = Long.parseLong(stX.nextToken());
            vertices[i][1] = Long.parseLong(stY.nextToken());
        }

        E = Double.parseDouble(br.readLine());
    }
}