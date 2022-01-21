/**
 * 소수&팰린드롬
 * https://www.acmicpc.net/problem/1747
 */
package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main_1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(br.readLine());
        System.out.println(getPrimeAndPalindromeNumberBiggerThan(n));
    }
 
    private static int getPrimeAndPalindromeNumberBiggerThan(int n) {
        int i = n;
        while (true) {
            if (isPrime(i) && isPalindrome(i))
                return i;
 
            i++;
        }
    }
 
    private static boolean isPrime(int n) {
        if (n == 1)
            return false;
 
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
 
        return true;
    }
 
    private static boolean isPalindrome(int i) {
        String s = String.valueOf(i);
        int l = 0;
        int r = s.length() - 1;
 
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
 
            l++;
            r--;
        }
 
        return true;
    }
 
}