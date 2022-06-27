package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019 {
    static class State {
        int n;
        int path;

        public State(int n, int path) {
            this.n = n;
            this.path = path;
        }
    }

    private static int TC;
    private static int a, b;
    private static final boolean[] visited = new boolean[10000];
    private static final int[] dn = {1, 2, 3, 4};
    private static final char[] ins = {'D', 'S', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(bfs()).append('\n');
            Arrays.fill(visited, false);
        }

        System.out.println(sb);
    }

    private static String bfs() {
        Queue<State> q = new LinkedList<>();

        visited[a] = true;
        q.offer(new State(a, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.n == b)
                return resolve(cur.path);

            for (int i : dn) {
                int next = getNext(cur.n, i);

                if (visited[next])
                    continue;

                visited[next] = true;
                q.offer(new State(next, cur.path * 5 + i));
            }
        }

        return null;
    }

    private static String resolve(int path) {
        StringBuilder sb = new StringBuilder();
        while (path > 0) {
            int mod = path % 5;
            sb.insert(0, ins[mod - 1]);
            path /= 5;
        }
        return sb.toString();
    }

    private static int getNext(int n, int i) {
        int ret = 0;

        if (i == 1) {
            ret = 2 * n;
            if (ret >= 10000)
                ret %= 10000;
        }

        if (i == 2) {
            if (n == 0)
                ret = 9999;
            else
                ret = n - 1;
        }

        if (i == 3) {
            int maxDigit = getMaxDigit(n);
            if (maxDigit == 0)
                return n;
            else if (maxDigit == 1000) {
                int quote = n / 1000;
                n %= 1000;
                n *= 10;
                n += quote;
            } else
                n *= 10;

            ret = n;
        }

        if (i == 4) {
            int maxDigit = getMaxDigit(n);
            if (maxDigit == 0)
                return n;
            int mod = n % 10;
            n /= 10;
            n += mod * 1000;
            ret = n;
        }

        return ret;
    }

    private static int getMaxDigit(int n) {
        int ret = 1;
        while (ret <= n)
            ret *= 10;

        return ret / 10;
    }
}