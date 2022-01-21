/**
 * 최소비용 구하기 2
 * https://www.acmicpc.net/problem/11779
 */
package Baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_11779 {
    static class Pair implements Comparable<Pair> {
        int num;
        int cost;
 
        public Pair(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
 
        @Override
        public int compareTo(Pair p) {
            return Integer.compare(this.cost, p.cost);
        }
    }
 
    private static int n, m, src, dest;
    private static List<Pair>[] adj;
    private static int[] pre;
    private static int[] minCost;
    private static PriorityQueue<Pair> pq = new PriorityQueue<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adj = new List[n + 1];
        minCost = new int[n + 1];
        pre = new int[n + 1];
 
        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();
 
        StringTokenizer st;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
 
            adj[u].add(new Pair(v, cost));
        }
 
        st = new StringTokenizer(br.readLine());
        src = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());
 
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        pq.offer(new Pair(src, 0));
 
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.cost != minCost[cur.num])
                continue;
 
            for (Pair nx : adj[cur.num]) {
                if (minCost[nx.num] > minCost[cur.num] + nx.cost) {
                    minCost[nx.num] = minCost[cur.num] + nx.cost;
                    pq.offer(new Pair(nx.num, minCost[nx.num]));
                    pre[nx.num] = cur.num;
                }
            }
        }
 
        System.out.println(minCost[dest]);
 
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = dest;
        while (cur != 0) {
            stack.push(cur);
            cur = pre[cur];
        }
 
        System.out.println(stack.size());
 
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop()).append(' ');
 
        System.out.println(sb);
    }
}
