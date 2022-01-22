/**
 * 시험 감독
 * https://www.acmicpc.net/problem/13458
 */
package Baekjoon.Simulation._13458;

import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] input = br.readLine().split(" ");
        int b = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
 
        long total = n;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            num -= b;
 
            if (num > 0)
                total += (long) Math.ceil((double) num / c);
        }
 
        System.out.println(total);
    }
}