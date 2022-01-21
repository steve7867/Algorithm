/**
 * Moo 게임
 * https://www.acmicpc.net/problem/5904
 */
package Baekjoon.Recursion;

import java.util.*;
 
public class Main_5904 {
    static int N;
    static int[] D = new int[150];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        D[0] = 3;
        for (int i = 1; i < 40; i++)
            D[i] = D[i - 1] * 2 + (i + 3);
        N = sc.nextInt();
        
        System.out.println(solve(N));
    }
    
    static char solve(int N) {
        if (N == 1) return 'm';
        if (N == 2 || N == 3) return 'o';
        int i = 0;
        while (D[i] < N) i++; 
        if (D[i] == N) return 'o';
        if (N - D[i-1] == 1) return 'm';
        if (N - D[i-1] <= i+3) return 'o';
        return solve(N - D[i-1] - (i+3));
    }
}
