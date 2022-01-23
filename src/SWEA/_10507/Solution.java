package SWEA._10507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] input = new int[200_000];
    private static final boolean[] study = new boolean[1_200_001];
    private static int n;
    private static int p;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int TC = stoi(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            input();
            fillStudy();

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(search())
                    .append('\n');

            reset();
        }

        System.out.println(sb);
    }

    private static void fillStudy() {
        for (int i = 0; i < n; i++)
            study[input[i]] = true;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        p = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            input[i] = (stoi(st.nextToken()));
    }

    private static void reset() {
        for (int i = 0; i < n; i++)
            study[input[i]] = false;
    }

    private static int search() {
        int ret = 0;
        int upperBound = input[n - 1] + p;

        int s = 0, e = 0;
        while (e <= upperBound) {
            if (study[e]) {
                e++;
                ret = Math.max(ret, e - s);
            } else if (p > 0) {
                e++;
                p--;
                ret = Math.max(ret, e - s);
            } else if (study[s]) {
                s++;
            } else {
                s++;
                p++;
            }
        }

        return ret;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

}