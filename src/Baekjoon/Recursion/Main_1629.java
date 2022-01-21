/**
 * 곱셈
 * https://www.acmicpc.net/problem/1629
 */
package Baekjoon.Recursion;

import java.util.*;
 
class Main_1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        
        System.out.println(func(a,b,c));
    }
    
    private static long func(long a, long b, long m) {
        if (b == 1) return a % m;
        long val = func(a, b / 2, m);
        val = val * val % m;
        if (b % 2 == 0) return val;
        else return val * a % m;
    }
}