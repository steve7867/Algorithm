/**
 * 종이 조각
 * https://www.acmicpc.net/problem/14391
 */
package Baekjoon.Bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_14391 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++)
                paper[i][j] = input.charAt(j) - '0';
        }
 
        // 0: -, 1 : |
        int ans = 0;
        for (int s = 0; s < (1 << (n * m)); s++) {
            int sum = 0;
 
            for (int i = 0; i < n; i++) {
                int cur = 0;
                for (int j = 0; j < m; j++) {
                    int k = i * m + j;
 
                    if ((s & (1 << k)) == 0)
                        cur = cur * 10 + paper[i][j];
                    else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
 
            for (int j = 0; j < m; j++) {
                int cur = 0;
                for (int i = 0; i < n; i++) {
                    int k = i * m + j;
 
                    if ((s & (1 << k)) != 0)
                        cur = cur * 10 + paper[i][j];
                    else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
 
            ans = Math.max(ans, sum);
        }
 
        System.out.println(ans);
    }
}
