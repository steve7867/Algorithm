/**
 * 줄 세우기
 * https://www.acmicpc.net/problem/2252
 */
package Baekjoon.Topological_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        ArrayList<Integer>[] a = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            a[i] = new ArrayList<>();
        int[] indegree = new int[n + 1];
 
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int cur = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
 
                a[cur].add(next);
                indegree[next]++;
                cur = next;
            }
        }
 
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
 
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            sum += cur;
 
            sb.append(cur).append('\n');
 
            for (int j : a[cur]) {
                indegree[j]--;
 
                if (indegree[j] == 0)
                    q.offer(j);
            }
        }
 
        if (sum != n * (n + 1) / 2) {
            System.out.println(0);
            return;
        }
 
        System.out.println(sb);
    }
}