/**
 * 거의 소수
 * https://www.acmicpc.net/problem/1456
 */
package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_1456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
 
        int b = (int) Math.sqrt(B);
        boolean[] isPrime = sieve(b);
 
        System.out.println(getAnswer(A, B, b, isPrime));
    }
 
    private static int getAnswer(long A, long B, int b, boolean[] isPrime) {
        int cnt = 0;
 
        BigInteger A_BI = BigInteger.valueOf(A);
        BigInteger B_BI = BigInteger.valueOf(B);
 
        for (int i = 2; i <= b; i++) {
            if (!isPrime[i])
                continue;
 
            BigInteger i_BI = BigInteger.valueOf(i);
 
            for (BigInteger j_BI = BigInteger.valueOf((long) i * i); j_BI.compareTo(B_BI) <= 0; j_BI = j_BI.multiply(i_BI)) {
                if (j_BI.compareTo(A_BI) >= 0)
                    cnt++;
            }
 
        }
 
        return cnt;
    }
 
    private static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
 
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i])
                continue;
 
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
 
        return isPrime;
    }
 
}