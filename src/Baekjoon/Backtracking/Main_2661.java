package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2661 {
    private static int n;
    private static String ans;
    private static final int[] nums = {1, 2, 3};
    private static boolean gotAnswer = false;

    public static void main(String[] args) throws IOException {
        init();
        backtrack(new StringBuilder());
        System.out.println(ans);
    }

    private static void backtrack(StringBuilder sb) {
        if (isBad(sb))
            return;

        if (sb.length() == n) {
            ans = sb.toString();
            gotAnswer = true;
            return;
        }

        for (int num : nums) {
            sb.append(num);
            backtrack(sb);
            if (gotAnswer)
                return;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean isBad(StringBuilder sb) {
        int len = sb.length();

        for (int unit = 1; unit <= len / 2; unit++)
            if (equals(sb, len, unit))
                return true;

        return false;
    }

    private static boolean equals(StringBuilder sb, int len, int unit) {
        for (int j = 0; j < unit; j++)
            if (sb.charAt(len - 2 * unit + j) != sb.charAt(len - unit + j))
                return false;

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }
}