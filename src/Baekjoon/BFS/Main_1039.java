package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1039 {

    private static int N;
    private static int K;
    private static final boolean[] visited = new boolean[1_000_001];

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        for (int k = 0; k < K; k++) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int cur = q.poll();

                int maxMod = calculate(cur);
                for (int j = 1; j < maxMod; j *= 10) {
                    for (int i = j * 10; i <= maxMod; i *= 10) {
                        int next = swap(cur, i, j, maxMod);
                        if (next == -1)
                            continue;

                        if (visited[next])
                            continue;

                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }

            for (int i : q)
                visited[i] = false;
        }

        if (q.isEmpty())
            return -1;

        int ans = 0;
        for (int i : q)
            if (i > ans)
                ans = i;

        return ans;
    }

    private static int calculate(int num) {
        int i = 1;
        while (i <= num)
            i *= 10;

        return i / 10;
    }

    private static int swap(int num, int i, int j, int maxMod) {
        int a = extract(num, i);
        int b = extract(num, j);
        if (b == 0 && i == maxMod)
            return -1;

        num -= a * i;
        num += b * i;

        num -= b * j;
        num += a * j;

        return num;
    }

    private static int extract(int num, int i) {
        int a = num / i;
        return a % 10;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}