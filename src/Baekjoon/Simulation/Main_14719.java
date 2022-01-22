/**
 * 빗물
 * https://www.acmicpc.net/problem/14719
 *
 * 문제 해설: https://entrydeveloper.tistory.com/438
 * 다양한 풀이가 있으니 꼭 확인해 볼 것것 */
package Baekjoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719 {
    private static int w, h;
    private static int[] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        h = Integer.parseInt(stringTokenizer.nextToken());
        w = Integer.parseInt(stringTokenizer.nextToken());

        height = new int[w];

        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++)
            height[i] = Integer.parseInt(stringTokenizer.nextToken());

        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int lMax = 0;
            for (int j = 0; j <= i; j++)
                lMax = Math.max(lMax, height[j]);

            int rMax = 0;
            for (int j = i; j < height.length; j++)
                rMax = Math.max(rMax, height[j]);

            ans += Math.min(lMax, rMax) - height[i];
        }

        System.out.println(ans);
    }
}