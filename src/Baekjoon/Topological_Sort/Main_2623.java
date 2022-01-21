/**
 * 음악프로그램
 * https://www.acmicpc.net/problem/2623
 * 문제 해설: https://entrydeveloper.tistory.com/394
 */
package Baekjoon.Topological_Sort;

import java.io.*;
import java.util.*;

public class Main_2623 {
    private static int n, m;
    private static List<Integer>[] adj;
    private static int[] indgree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new List[n + 1];
        indgree = new int[n + 1];

        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int u = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                adj[u].add(v);
                indgree[v]++;
                u = v;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            if (indgree[i] == 0)
                q.offer(i);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append('\n');
            cnt++;

            for (int nx : adj[cur]) {
                indgree[nx]--;
                if (indgree[nx] == 0)
                    q.offer(nx);
            }
        }

        System.out.println((cnt != n) ? 0 : sb);
    }
}