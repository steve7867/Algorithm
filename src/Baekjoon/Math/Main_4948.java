/**
 * 베르트랑 공준
 * https://www.acmicpc.net/problem/4948
 */
package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main_4948 {
 
    private static final int MAX = 123_456;
 
    public static void main(String[] args) throws IOException {
        boolean[] isPrime = new boolean[2 * MAX + 1];
        int[] prefixSum = new int[2 * MAX + 1];
 
        sieve(isPrime);
        makePrefix(isPrime, prefixSum);
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
 
            sb.append(prefixSum[2 * n] - prefixSum[n]).append('\n');
        }
 
        System.out.println(sb);
    }
 
    private static void makePrefix(boolean[] isPrime, int[] prefixSum) {
        prefixSum[1] = 0;
        for (int i = 2; i <= 2 * MAX; i++)
            prefixSum[i] = isPrime[i] ? prefixSum[i - 1] + 1 : prefixSum[i - 1];
    }
 
    private static void sieve(boolean[] isPrime) {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
 
        for (int i = 2; i * i <= 2 * MAX; i++) {
            if (!isPrime[i])
                continue;
 
            for (int j = i * i; j <= 2 * MAX; j += i)
                isPrime[j] = false;
        }
    }
}
