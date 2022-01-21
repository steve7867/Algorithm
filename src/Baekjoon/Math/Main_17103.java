/**
 * 골드바흐 파티션
 * https://www.acmicpc.net/problem/17103
 */
package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main_17103 {
    public static void main(String[] args) throws IOException {
        boolean[] isPrime = sieve();
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(getNumOfGoldBach(n, isPrime))
                    .append('\n');
        }
 
        System.out.println(sb);
    }
 
    private static int getNumOfGoldBach(int n, boolean[] isPrime) {
        int cnt = 0;
 
        for (int a = 2; a <= n / 2; a++) {
            int b = n - a;
            if (!(isPrime[a] && isPrime[b]))
                continue;
 
            cnt++;
        }
 
        return cnt;
    }
 
    private static boolean[] sieve() {
        int million = 1_000_000;
        boolean[] isPrime = new boolean[million + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
 
        for (int i = 2; i * i <= million; i++) {
            if (!isPrime[i])
                continue;
 
            for (int j = i * i; j <= million; j += i) {
                isPrime[j] = false;
            }
        }
 
        return isPrime;
    }
}