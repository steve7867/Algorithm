/**
 * 비용
 * https://www.acmicpc.net/problem/2463
 * 문제 해설: https://entrydeveloper.tistory.com/538
 */
package Baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_2463 {
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
        public int compareTo(Edge e) {
            return Integer.compare(this.cost, e.cost);
        }
    }
 
    private static int[] p;
    private static int[] size;
    private static final long mod = 1_000_000_000L;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        p = new int[n + 1];
        for (int i = 0; i <= n; i++)
            p[i] = i;
 
        size = new int[n + 1];
        Arrays.fill(size, 1);
 
        List<Edge> list = new ArrayList<>();
 
        long sum = 0L;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
 
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
 
            list.add(new Edge(x, y, cost));
            sum += cost;
        }
 
        list.sort(Collections.reverseOrder());
 
        long ans = 0L;
        for (Edge edge : list) {
            int x = edge.x;
            int y = edge.y;
            int cost = edge.cost;
 
            int xRoot = find(x);
            int yRoot = find(y);
 
            if (xRoot != yRoot) {
                int xSetSize = size[xRoot];
                int ySetSize = size[yRoot];
 
                ans += ((long) xSetSize * ySetSize) * sum;
                ans %= mod;
 
                union(x, y);
            }
 
            sum -= cost;
        }
 
        System.out.println(ans);
    }
 
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
 
        if (aRoot == bRoot)
            return;
 
        int c = Integer.compare(size[aRoot], size[bRoot]);
        if (c >= 0) {
            p[bRoot] = aRoot;
            size[aRoot] += size[bRoot];
        } else {
            p[aRoot] = bRoot;
            size[bRoot] += size[aRoot];
        }
    }
 
    private static int find(int i) {
        if (i != p[i]) {
            p[i] = find(p[i]);
        }
 
        return p[i];
    }
}
