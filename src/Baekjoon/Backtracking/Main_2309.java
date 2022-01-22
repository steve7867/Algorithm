/**
 * 일곱 난쟁이
 * https://www.acmicpc.net/problem/2309
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
 
public class Main_2309 {
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();
    private static int[] height = new int[9];
    private static int[] combi = new int[7];
 
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++)
            height[i] = Integer.parseInt(br.readLine());
 
        func(0, 0);
        System.out.println(sb);
    }
 
    private static void func(int k, int start) {
        if (k == 7) {
            int sum = 0;
            for (int i = 0; i < 7; i++)
                sum += combi[i];
 
            if (sum == 100) {
                Arrays.sort(combi);
                for (int i = 0; i < 7; i++)
                    sb.append(combi[i]).append("\n");
            }
 
            return;
        }
 
        for (int i = start; i < 9; i++) {
            combi[k] = height[i];
            func(k + 1, i + 1);
        }
    }
}
