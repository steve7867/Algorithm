/**
 * Philosopher’s Walk
 * https://www.acmicpc.net/problem/14956
 */
package Baekjoon.Recursion;

import java.util.*;
 
public class Main_14956 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();
        long K = 1;
        while (1 << K != N) K++;
        M--;
        Pair ans = solve(M, K);
        System.out.println(ans.first + " " + ans.second);
    }
    
    static Pair solve(long M, long K) {
        if (K == 1) {
            if (M == 0) return new Pair(1, 1);
            if (M == 1) return new Pair(1, 2);
            if (M == 2) return new Pair(2, 2);
            if (M == 3) return new Pair(2, 1);
        }
        long p2 = 1 << K;
        long square = M / (1 << (2 * K - 2));
        Pair coor = solve(M - square * (1 << (2 * K - 2)), K - 1);
        if (square == 0) return new Pair(coor.second, coor.first);
        if (square == 1) return new Pair(coor.first, coor.second + p2 / 2);
        if (square == 2) return new Pair(coor.first + p2 / 2, coor.second + p2 / 2);
        return new Pair(p2 + 1 - coor.second, p2 / 2 + 1 - coor.first);
    }
}
 
class Pair {
    long first;
    long second;
    
    Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}
