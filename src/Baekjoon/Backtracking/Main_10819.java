package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819 {

    private static int n;
    private static int[] inputArr;
    private static int[] arr;
    private static boolean[] isUsed;
    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        backtrack(0);
        System.out.println(ans);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        inputArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            inputArr[i] = Integer.parseInt(st.nextToken());

        arr = new int[n];
        isUsed = new boolean[n];
    }

    private static void backtrack(int cur) {
        if (cur == n) {
            ans = Math.max(ans, calculate(arr));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isUsed[i])
                continue;

            isUsed[i] = true;
            arr[cur] = inputArr[i];
            backtrack(cur + 1);
            isUsed[i] = false;
        }
    }

    private static int calculate(int[] arr) {
        int res = 0;

        for (int i = 0; i < n - 1; i++)
            res += Math.abs(arr[i] - arr[i + 1]);

        return res;
    }
}
