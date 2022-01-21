/**
 * 수 복원하기
 * https://www.acmicpc.net/problem/2312
 */
package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
 
public class Main_2312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
 
            Map<Integer, Integer> occur = factorization(n);
            for (int key : occur.keySet()) {
                int val = occur.get(key);
                sb.append(key)
                        .append(' ')
                        .append(val)
                        .append('\n');
            }
        }
 
        System.out.println(sb);
    }
 
    private static Map<Integer, Integer> factorization(int n) {
        Map<Integer, Integer> occur = new TreeMap<>();
 
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                occur.put(i, occur.getOrDefault(i, 0) + 1);
            }
        }
 
        if (n != 1)
            occur.put(n, 1);
 
        return occur;
    }
}