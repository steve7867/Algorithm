package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798 {
    private static int n;
    private static int m;
    private static int[] arr;
    private static int ans;
    private static boolean ended;

    public static void main(String[] args) throws IOException {
        init();
        backtrack(0, 0, 0);
        System.out.println(ans);
    }

    private static void backtrack(int sum, int num, int i) {
        if (sum > m)
            return;

        if (num == 3) {
            if (isCloser(sum))
                ans = sum;

            if (ans == m)
                ended = true;

            return;
        }

        if (i == n)
            return;


        backtrack(sum + arr[i], num + 1, i + 1);

        if (ended)
            return;

        backtrack(sum, num, i + 1);
    }

    private static boolean isCloser(int sum) {
        return Math.abs(m - sum) < Math.abs(m - ans);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        ans = Integer.MAX_VALUE;

        ended = false;
    }

}