/**
 * 장난감 조립
 * https://www.acmicpc.net/problem/2637
 * 문제 해설: https://entrydeveloper.tistory.com/532
 */
package Baekjoon.Topological_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2637 {

    private static List<Pair>[] adjList;
    private static int[] inDegree;
    private static int[] cnt;
    private static final List<Integer> basicPartList = new ArrayList<>();

    private static class Pair implements Comparable<Pair> {
        int y;
        int k;

        public Pair(int y, int k) {
            this.y = y;
            this.k = k;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.y, o.y);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = input();

        topologicalSort(n);

        System.out.println(getAnswer());
    }

    private static void topologicalSort(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        cnt[n] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (adjList[cur].isEmpty()) {
                basicPartList.add(cur);
                continue;
            }

            for (Pair pair : adjList[cur]) {
                int nxt = pair.y;
                int c = pair.k;
                cnt[nxt] += cnt[cur] * c;

                if (--inDegree[nxt] == 0)
                    q.offer(nxt);
            }
        }
    }

    private static String getAnswer() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(basicPartList);
        for (int num : basicPartList) {
            sb.append(num)
                    .append(' ')
                    .append(cnt[num])
                    .append('\n');
        }

        return sb.toString();
    }

    private static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        adjList = new List[n + 1];
        inDegree = new int[n + 1];
        cnt = new int[n + 1];
        for (int i = 1; i <= n; i++)
            adjList[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            adjList[x].add(new Pair(y, k));
            inDegree[y]++;
        }
        return n;
    }
}