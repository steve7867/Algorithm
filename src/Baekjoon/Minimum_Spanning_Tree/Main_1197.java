/**
 * 최소 스패닝 트리
 * https://www.acmicpc.net/problem/1197
 */
package Baekjoon.Minimum_Spanning_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class Main_1197 {
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
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
 
        p = new int[v + 1];
        for (int i = 1; i <= v; i++)
            p[i] = i;
 
        rank = new int[v + 1];
        Arrays.fill(rank, 0);
 
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
 
            list.add(new Edge(x, y, cost));
        }
 
        Collections.sort(list);
 
        int ans = 0;
        int cnt = 0;
        for (Edge edge : list) {
            int x = edge.x;
            int y = edge.y;
            int cost = edge.cost;
 
            if (!isInSameGroup(x, y)) {
                union(x, y);
                ans += cost;
                if (++cnt >= v - 1)
                    break;
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
 
    private static boolean isInSameGroup(int a, int b) {
        return find(a) == find(b);
    }
 
    private static int find(int i) {
        if (i != p[i])
            p[i] = find(p[i]);
 
        return p[i];
    }
}
