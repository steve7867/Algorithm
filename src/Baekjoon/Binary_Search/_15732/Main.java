/*
    도토리 숨기기
    https://www.acmicpc.net/problem/15732
 */
package Baekjoon.Binary_Search._15732;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int k;
    private static int d;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    private static int[][] rules;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(getAns());
    }

    private static int getAns() {
        int l = min;
        int r = max;

        while (l < r) {
            int mid = l + (r - l) / 2;
            long acorn = getArcon(mid);

            if (acorn >= d)
                r = mid;
            else
                l = mid + 1;
        }

        return r;
    }

    private static long getArcon(int deadLine) {
        long ret = 0;

        for (int[] rule : rules) {
            int start = rule[0];
            int end = rule[1];
            int term = rule[2];
            
            if (deadLine < start)
                continue;

            if (deadLine >= end) {
                ret += (end - start) / term + 1;
                continue;
            }

            ret += (deadLine - start) / term + 1;
        }

        return ret;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        rules = new int[k][3];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            rules[i][0] = Integer.parseInt(st.nextToken());
            min = Math.min(min, rules[i][0]);

            rules[i][1] = Integer.parseInt(st.nextToken());
            max = Math.max(max, rules[i][1]);

            rules[i][2] = Integer.parseInt(st.nextToken());
        }
    }
}