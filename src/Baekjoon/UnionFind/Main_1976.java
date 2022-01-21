/**
 * 여행 가자
 * https://www.acmicpc.net/problem/1976
 */
package Baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_1976 {
 
    private static int[] p;
    private static int[] rank;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
 
        p = new int[n + 1];
        for (int i = 1; i <= n; i++)
            p[i] = i;
 
        rank = new int[n + 1];
        Arrays.fill(rank, 0);
 
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
 
                if (num == 1 && i < j) {
                    union(i, j);
                }
            }
        }
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dest = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m - 1; i++) {
            int src = dest;
            dest = Integer.parseInt(st.nextToken());
            if (!canGo(src, dest)) {
                System.out.println("NO");
                return;
            }
        }
 
        System.out.println("YES");
    }
 
    private static boolean canGo(int a, int b) {
        return find(a) == find(b);
    }
 
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
 
        if (aRoot == bRoot)
            return;
 
        int aRootRank = rank[aRoot];
        int bRootRank = rank[bRoot];
 
        if (aRootRank < bRootRank) {
            p[aRoot] = bRoot;
        } else if (aRootRank > bRootRank) {
            p[bRoot] = aRoot;
        } else {
            p[bRoot] = aRoot;
            rank[aRoot]++;
        }
    }
 
    private static int find(int i) {
        if (i != p[i])
            p[i] = find(p[i]);
 
        return p[i];
    }
}
