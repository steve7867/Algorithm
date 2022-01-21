/**
 * 분해합
 * https://www.acmicpc.net/problem/2231
 */
package Baekjoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static String s;

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        N = Integer.parseInt(s);

        for (int i = N - 9 * s.length(); i < N; i++) {
            if (i < 0) continue;
            
            if (isConstructor(i)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }

    private static boolean isConstructor(int i) {
        int sum = i;
        while (i > 0) {
            int remainder = i % 10;
            sum += remainder;
            i /= 10;
        }
        return sum == N ? true : false;
    }
}