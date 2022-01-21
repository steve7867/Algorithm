/**
 * 소수 찾기
 * https://www.acmicpc.net/problem/1978
 */
package Baekjoon.Math;

import java.io.*;
import java.util.*;
 
public class Main_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(br.readLine());
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++)
            if (isPrime(Integer.parseInt(st.nextToken())))
                ans++;
 
        System.out.println(ans);
    }
 
    private static boolean isPrime(int n) {
        if (n == 1)
            return false;
 
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
 
        return true;
    }
}