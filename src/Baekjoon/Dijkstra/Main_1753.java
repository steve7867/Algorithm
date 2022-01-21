/**
 * 최단경로
 * https://www.acmicpc.net/problem/1753
 */
package Baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_1753 {
 
    static class Pair implements Comparable<Pair> {
        int num; // 정점의 번호
        int dist; // 거리
 
        public Pair(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
 
        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
 
    private static int v, e;
    private static int k;
    private static List<Pair>[] adj;
    private static int[] minDist;
    private static PriorityQueue<Pair> pq = new PriorityQueue<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
 
        adj = new List[v + 1];
        minDist = new int[v + 1];
 
        for (int i = 0; i <= v; i++)
            adj[i] = new ArrayList<>();
 
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
 
            adj[u].add(new Pair(v, d));
        }
 
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[k] = 0;
        pq.offer(new Pair(k, 0));
 
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (minDist[cur.num] != cur.dist)
                continue;
 
            for (Pair nx : adj[cur.num]) {
                int num = nx.num;
                int dist = nx.dist;
 
                if (minDist[num] > minDist[cur.num] + dist) {
                    minDist[num] = minDist[cur.num] + dist;
                    pq.offer(new Pair(num, minDist[nx.num]));
                }
            }
        }
 
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= minDist.length - 1; i++) {
            sb.append((minDist[i] == Integer.MAX_VALUE) ? "INF" : minDist[i]);
            sb.append('\n');
        }
 
        System.out.println(sb);
    }
}