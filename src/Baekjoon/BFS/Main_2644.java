package Baekjoon.BFS;

import java.util.*;
import java.io.*;

public class Main_2644 {
    private static int n;
    private static int a, b;
    private static final List<Integer>[] adjList = new List[101];
    private static final int[] dist = new int[101];

    static {
        for (int i = 1; i <= 100; i++)
            adjList[i] = new ArrayList<>();

        Arrays.fill(dist, -1);
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        dist[a] = 0;
        q.offer(a);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == b)
                return dist[cur];

            for (int next : adjList[cur]) {
                if (dist[next] >= 0)
                    continue;

                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }

        return -1;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }
    }
}