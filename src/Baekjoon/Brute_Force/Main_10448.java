/**
 * 유레카 이론
 * https://www.acmicpc.net/problem/10448
 * 문제 해설: https://entrydeveloper.tistory.com/235
 */
package Baekjoon.Brute_Force;

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
                for (int j = 1; j < 45; j++) {
                    for (int l = 1; l < 45; l++) {
                        if (t[i] + t[j] + t[l] == k) {
                            possible = true;
                            break;
                        }
                    }
                    if (possible) break;
                }
                if (possible) break;
            }
            bw.write(possible ? "1\n" : "0\n");
        }
        bw.flush();
    }
}
