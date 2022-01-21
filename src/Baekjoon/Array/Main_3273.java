/**
 * 두 수의 합
 * https://www.acmicpc.net/problem/3273
 */
package Baekjoon.Array;

import java.io.*;
import java.util.StringTokenizer;

public class Main_3273 {
    public static void main (String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] occur = new int[1000001];
        br.readLine(); //필요 없어서 버림
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        
        int count = 0;
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if ((x - n <= 1000000 && x - n >= 1) && occur[x - n] > 0)
                count++;
            occur[n]++;
        }
        System.out.println(count);
    }
}