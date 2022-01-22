/**
 * 유레카 이론
 * https://www.acmicpc.net/problem/10448
 * 문제 해설: https://entrydeveloper.tistory.com/235
 */
package Baekjoon.Backtracking;

import java.io.*;
 
public class Main_10448 {
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int tc;
    private static int k;
    private static int[] t = new int[45];
    private static int[] arr = new int[3];
    
    static {
        for (int i = 1; i < 45; i++)
            t[i] = i * (i + 1) / 2;
    }
    
    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            k = Integer.parseInt(br.readLine());
            bw.write(func(0, false) ? "1\n" : "0\n");
        }
        bw.flush();
    }
    
    private static boolean func(int idx, boolean possible) {
        if (idx == 3) {
            if (arr[0] + arr[1] + arr[2] == k) possible = true;
            return possible;
        }
        
        for (int i = 1; i < 45; i++) {
            arr[idx] = t[i];
            possible = func(idx + 1, possible);
            if (possible) break;
        }
        
        return possible;
    }
}