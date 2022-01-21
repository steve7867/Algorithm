/**
 * 타임머신
 * https://www.acmicpc.net/problem/11657
 */
package Baekjoon.Bellman_Ford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main_11657 {
 
    private static class Pair{
        int num;
        int dist;
 
        public Pair(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
 
    private static int n, m;
    private static List<Pair>[] adj;
    private static long[] dist;
    private static final long INF = Long.MAX_VALUE;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
 
        adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
 
        dist = new long[n];
 
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
 
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
 
            adj[a].add(new Pair(b, c));
        }
 
        Arrays.fill(dist, INF);
        dist[0] = 0;
 
        for (int i = 1; i <= n - 1; i++) {
            for (int u = 0; u < n; u++) {
                if (dist[u] == INF)
                    continue;
 
                for (Pair p : adj[u]) {
                    int v = p.num;
                    int d = p.dist;
 
                    if (dist[v] > dist[u] + d)
                        dist[v] = dist[u] + d;
                }
            }
        }
 
        for (int u = 0; u < n; u++) {
            if (dist[u] == INF)
                continue;
 
            for (Pair p : adj[u]) {
                int v = p.num;
                int d = p.dist;
 
                if (dist[v] > dist[u] + d) {
                    System.out.println(-1);
                    return;
                }
            }
        }
 
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++)
            sb.append(dist[i] == INF ? -1 : dist[i]).append('\n');
 
        System.out.println(sb);
    }
}
