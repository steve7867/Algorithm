/**
 * LCM
 * https://www.acmicpc.net/problem/5347
 */
package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_5347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            int gcd = getGCD(a, b);
            long lcm = ((long) a / gcd) * b;
 
            sb.append(lcm).append('\n');
        }
 
        System.out.println(sb);
    }
 
    private static int getGCD(int a, int b) {
        if (b == 0)
            return a;
 
        return getGCD(b, a % b);
    }
 
}
