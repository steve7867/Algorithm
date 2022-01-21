/**
 * 카잉 달력
 * https://www.acmicpc.net/problem/6064
 */
package Baekjoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]) - 1;
            int y = Integer.parseInt(input[3]) - 1;
 
            boolean find = false;
            for (int year = x; year < (M * N); year += M) {
                if (year % N == y) {
                    System.out.println(year + 1);
                    find = true;
                    break;
                }
            }
            if (!find)
                System.out.println(-1);
        }
    }
}
