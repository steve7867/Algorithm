/**
 * 에라토스테네스의 체
 * https://www.acmicpc.net/problem/2960
 */
package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_2960 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
        System.out.println(sieve(n, k));
    }
 
    private static int sieve(int n, int k) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
 
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i])
                continue;
 
            cnt++;
            if (cnt == k)
                return i;
 
            for (int j = i * i; j <= n; j += i) {
                if (!isPrime[j])
                    continue;
 
                isPrime[j] = false;
                cnt++;
                if (cnt == k)
                    return j;
            }
        }
 
        return -1;
    }
}
