/**
 * 리모컨
 * https://www.acmicpc.net/problem/1107
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_1107 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static String target;
    private static int N, M;
    private static int min;
    private static boolean[] broken = new boolean[10];
 
    public static void main(String[] args) throws IOException {
        target = br.readLine();
        N = Integer.parseInt(target);
        M = Integer.parseInt(br.readLine());
        if (M > 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            broken[num] = true;
        }
        
        min = Math.abs(100 - N);
        backTrack();
        System.out.println(min);
    }
    
    private static void backTrack() {
        if (sb.length() - target.length() == 2) return;
        if (sb.length() >= 1 
                && Math.abs(sb.length() - target.length()) <= 1) {
            int channel = Integer.parseInt(sb.toString());
            int cnt = sb.length() + Math.abs(channel - N);
            min = cnt <= min ? cnt : min;
        }
        
        for (int i = 0; i < 10; i++) {
            if (broken[i]) continue;
            sb.append(i);
            backTrack();
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
}
