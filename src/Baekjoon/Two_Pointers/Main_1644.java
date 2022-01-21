/**
 * 소수의 연속합
 * https://www.acmicpc.net/problem/1644
 */
package Baekjoon.Two_Pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        List<Integer> list = getPrimeNumbers(n);
        int len = list.size();
 
        int r = -1;
        int sum = 0;
        int cnt = 0;
        for (int l = 0; l < len; sum -= list.get(l), l++) {
            while (r < len - 1 && sum < n) {
                r++;
                sum += list.get(r);
            }
 
            if (sum == n)
                cnt++;
        }
 
        System.out.println(cnt);
    }
 
    private static List<Integer> getPrimeNumbers(int n) {
        List<Integer> ret = new ArrayList<>();
        if (n == 1)
            return ret;
 
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
 
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i])
                continue;
 
            for (int j = i * i; j <= n; j += i)
                isPrime[j] = false;
        }
 
        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
                ret.add(i);
        }
 
        return ret;
    }
}