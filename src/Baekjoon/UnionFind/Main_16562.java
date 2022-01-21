/**
 * 친구비
 * https://www.acmicpc.net/problem/16562
 */
package Baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_16562 {
    private static int[] p;
    private static int[] rank;
    private static int[] cost;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
        cost = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            cost[i] = Integer.parseInt(st.nextToken());
 
        p = new int[n + 1];
        for (int i = 1; i <= n; i++)
            p[i] = i;
 
        rank = new int[n + 1];
        Arrays.fill(rank, 0);
 
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
 
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            union(a, b);
        }
 
        int totalCost = 0;
        for (int i = 1; i <= n; i++) {
            if (i == p[i]) {
                totalCost += cost[i];
            }
        }
 
        System.out.println(totalCost > k ? "Oh no" : totalCost);
    }
 
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
 
        if (aRoot == bRoot)
            return;
 
        int c = Integer.compare(rank[aRoot], rank[bRoot]);
        if (c > 0) {
            p[bRoot] = aRoot;
            cost[aRoot] = Math.min(cost[aRoot], cost[bRoot]);
        } else if (c < 0) {
            p[aRoot] = bRoot;
            cost[bRoot] = Math.min(cost[bRoot], cost[aRoot]);
        } else {
            p[bRoot] = aRoot;
            cost[aRoot] = Math.min(cost[aRoot], cost[bRoot]);
            rank[aRoot]++;
        }
    }
 
    private static int find(int i) {
        if (i != p[i])
            p[i] = find(p[i]);
 
        return p[i];
    }
}