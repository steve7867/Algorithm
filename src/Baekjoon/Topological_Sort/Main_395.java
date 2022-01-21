/**
 * ACM Craft
 * https://www.acmicpc.net/problem/1005
 * 문제 해설: https://entrydeveloper.tistory.com/395
 */
package Baekjoon.Topological_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_395 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] cost = new int[n + 1];
            ArrayList<Integer>[] a = new ArrayList[n + 1]; //다음 정점을 저장
            ArrayList<Integer>[] b = new ArrayList[n + 1]; //이전 정점을 저장
            int[] indegree = new int[n + 1];
            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                a[i] = new ArrayList<>();
                b[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++)
                cost[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                a[u].add(v);
                b[v].add(u);
                indegree[v]++;
            }

            int w = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                    dp[i] = cost[i];
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int j : a[cur]) {
                    indegree[j]--;

                    if (indegree[j] == 0) {
                        int max = 0;
                        for (int l : b[j]) {
                            if (dp[l] > max)
                                max = dp[l];
                        }

                        dp[j] = max + cost[j];
                        q.offer(j);
                    }
                }
            }

            sb.append(dp[w]).append('\n');
        }

        System.out.println(sb);
    }
}