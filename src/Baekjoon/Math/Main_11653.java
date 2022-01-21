/**
 * 소인수분해
 * https://www.acmicpc.net/problem/11653
 */
package Baekjoon.Math;

import java.io.*;
import java.util.*;
 
public class Main_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(br.readLine());
        if (n == 1)
            return;
 
        List<Integer> list = factorization(n);
        StringBuilder sb = new StringBuilder();
        for (int i : list)
            sb.append(i).append('\n');
 
        System.out.println(sb);
    }
 
    private static List<Integer> factorization(int n) {
        List<Integer> factorList = new ArrayList<>();
 
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factorList.add(i);
                n /= i;
            }
        }
 
        if (n > 1)
            factorList.add(n);
 
        return factorList;
    }
}