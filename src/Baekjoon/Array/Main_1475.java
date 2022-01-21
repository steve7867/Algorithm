//https://www.acmicpc.net/problem/1475
package Baekjoon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] occur = new int[10];
        int num = Integer.parseInt(br.readLine());

        if (num == 0)
            occur[0]++;
        else {
            while (num > 0) {
                int n = num % 10;
                if (n == 9)
                    occur[6]++;
                else
                    occur[n]++;

                num /= 10;
            }
        }

        if (occur[6] % 2 == 1)
            occur[6] = occur[6] / 2 + 1;
        else
            occur[6] = occur[6] / 2;

        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (occur[i] > max)
                max = occur[i];
        }

        System.out.println(max);
    }
}