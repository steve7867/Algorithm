/**
 * 네트워크 연결
 * https://www.acmicpc.net/problem/1922
 */
package Baekjoon.Minimum_Spanning_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_1922 {
    private static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int cost;
 
        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
 
    private static int[] p;
    private static int[] rank;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
 
        p = new int[n + 1];
        for (int i = 0; i < n; i++)
            p[i] = i;
 
        rank = new int[n + 1];
        Arrays.fill(rank, 0);
 
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
 
            edgeList.add(new Edge(x, y, cost));
        }
 
        Collections.sort(edgeList);
 
        int cnt = 0;
        int ans = 0;
        for (Edge edge : edgeList) {
            int x = edge.x;
            int y = edge.y;
            int cost = edge.cost;
 
            if (!isInSameSet(x, y)) {
                union(x, y);
                ans += cost;
                if (++cnt == n - 1) {
                    break;
                }
            }
        }
 
        System.out.println(ans);
    }
 
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
 
        if (aRoot == bRoot)
            return;
 
        int c = Integer.compare(rank[aRoot], rank[bRoot]);
        if (c > 0) {
            p[bRoot] = aRoot;
        } else if (c < 0) {
            p[aRoot] = bRoot;
        } else {
            p[bRoot] = aRoot;
            rank[aRoot]++;
        }
    }
 
    private static boolean isInSameSet(int a, int b) {
        return find(a) == find(b);
    }
 
    private static int find(int i) {
        if (i != p[i])
            p[i] = find(p[i]);
 
        return p[i];
    }
}