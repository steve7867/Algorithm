/**
 * 환승
 * https://www.acmicpc.net/problem/5214
 *
 * 문제 해설: https://entrydeveloper.tistory.com/574
 */
package Baekjoon.Graph._5214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K, M;
    private static List<Integer>[] locList;
    private static List<Integer>[] hyper;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(BFS());
    }

    private static int BFS() {
        boolean[] hyperVisited = new boolean[M + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        dist[1] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == N)
                return dist[cur];

            for (int loc : locList[cur]) {
                if (hyperVisited[loc])
                    continue;

                hyperVisited[loc] = true;

                for (int next : hyper[loc]) {
                    if (dist[next] != -1)
                        continue;

                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }

        return -1;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        locList = new List[N + 1];
        for (int i = 1; i <= N; i++)
            locList[i] = new ArrayList<>();

        hyper = new List[M + 1];
        for (int i = 1; i <= M; i++)
            hyper[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                int station = Integer.parseInt(st.nextToken());

                hyper[i].add(station);
                locList[station].add(i);
            }
        }
    }
}