/**
 * 유레카 이론
 * https://www.acmicpc.net/problem/10448
 * 문제 해설: https://entrydeveloper.tistory.com/236
 */
package Baekjoon.Two_Pointers;

import java.io.*;

public class Main_10448 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int tc;
    private static int[] t = new int[45];
    
    static {
        for (int i = 1; i < 45; i++)
            t[i] = i * (i + 1) / 2;
    }
    
    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int k = Integer.parseInt(br.readLine());
            boolean possible = false;
            for (int i = 1; i < 45; i++) {
                int l = 1, r = 44;
                while (l <= r) {
                    int sum = t[i] + t[l] + t[r]; 
                    if (sum == k) {
                        possible = true;
                        break;
                    }
                    
                    if (sum > k) r--;
                    if (sum < k) l++;
                }
                if (possible) break;
            }
            bw.write(possible ? "1\n" : "0\n");
        }
        bw.flush();
    }
}