/**
 * 소수 구하기
 * https://www.acmicpc.net/problem/1929
 *
 * 에라토스테네스의 체를 이용해서 풀면 된다.
 */
package Baekjoon.Math;

import java.io.*;
import java.util.*;
 
public class Main_1929 {
    private static int m, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
 
        List<Integer> primeList = sieve(n);
        StringBuilder sb = new StringBuilder();
 
        for (int i : primeList)
            if (i >= m)
                sb.append(i).append('\n');
 
        System.out.println(sb);
    }
 
    private static List<Integer> sieve(int n) {
        List<Integer> primeList = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
 
        isPrime[1] = false;
 
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i])
                continue;
 
            for (int j = i * i; j <= n; j += i)
                isPrime[j] = false;
        }
 
        for (int i = 2; i <= n; i++)
            if (isPrime[i])
                primeList.add(i);
 
        return primeList;
    }
}
