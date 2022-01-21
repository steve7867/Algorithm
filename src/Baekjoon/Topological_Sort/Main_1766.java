/**
 * 문제집
 * https://www.acmicpc.net/problem/1766
 */
package Baekjoon.Topological_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main_1766 {
    public static void main(String[] args) throws IOException {
        List<Integer>[] adjList = input();
        int[] inDegree = makeInDegreeTable(adjList);
 
        String ans = topologicalSort(adjList, inDegree);
        System.out.println(ans);
    }
 
    private static String topologicalSort(List<Integer>[] adjList, int[] inDegree) {
        int n = adjList.length - 1;
 
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            }
        }
 
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(' ');
 
            for (int next : adjList[cur]) {
                inDegree[next]--;
 
                if (inDegree[next] == 0)
                    pq.offer(next);
            }
        }
 
        return sb.toString();
    }
 
    private static int[] makeInDegreeTable(List<Integer>[] adjList) {
        int n = adjList.length - 1;
        int[] inDegree = new int[n + 1];
 
        for (int i = 1; i <= n; i++) {
            for (int j : adjList[i]) {
                inDegree[j]++;
            }
        }
 
        return inDegree;
    }
 
    private static List<Integer>[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        List<Integer>[] adjList = new List[n + 1];
        for (int i = 1; i <= n; i++)
            adjList[i] = new ArrayList<>();
 
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
 
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            adjList[a].add(b);
        }
 
        return adjList;
    }
}
