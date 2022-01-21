/**
 * 리모컨
 * https://www.acmicpc.net/problem/1107
 */
package Baekjoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_1107 {
    static boolean[] broken;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        broken = new boolean[10];
 
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                broken[num] = true;
            }
        }
 
        int ans = Math.abs(100 - n);
 
        if (n == 100) {
            System.out.println(ans);
            return;
        }
 
        for (int c = 0; c <= 1000000; c++) {
            int click = getNumOfClick(c);
            if (click == 0)
                continue;
            ans = Math.min(ans, click + Math.abs(c - n));
        }
 
        System.out.println(ans);
    }
 
    // return how many times of clicking only number buttons should be made to reach the given channel(c)
    // If impossible only with number button, return 0
    private static int getNumOfClick(int c) {
        if (c == 0)
            return broken[0] ? 0 : 1;
 
        int click = 0;
        while (c > 0) {
            if (broken[c % 10])
                return 0;
            click++;
            c /= 10;
        }
 
        return click;
    }
}