/**
 * 공항
 * https://www.acmicpc.net/problem/10775
 * 문제 해설: https://entrydeveloper.tistory.com/537
 */
package Baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10775 {
    private static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        p = new int[G + 1];
        for (int i = 0; i <= G; i++)
            p[i] = i;

        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());

            int loc = find(g);
            if (loc == 0)
                break;

            union(loc, loc - 1);
            cnt++;
        }

        System.out.println(cnt);
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot)
            return;

        p[aRoot] = bRoot;
    }

    private static int find(int i) {
        if (i != p[i])
            p[i] = find(p[i]);

        return p[i];
    }
}