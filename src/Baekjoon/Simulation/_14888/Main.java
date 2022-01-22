/**
 * 연산자 끼워넣기
 * https://www.acmicpc.net/problem/14888
 */
package Baekjoon.Simulation._14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int n;
    static int[] num;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        operator[0] = Integer.parseInt(st.nextToken());
        operator[1] = Integer.parseInt(st.nextToken());
        operator[2] = Integer.parseInt(st.nextToken());
        operator[3] = Integer.parseInt(st.nextToken());
 
        backtrack(0, 0);
 
        System.out.println(max);
        System.out.println(min);
    }
 
    private static void backtrack(int idx, int res) {
        if (idx == n) {
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }
 
        if (idx == 0) {
            backtrack(idx + 1, num[idx]);
            return;
        }
 
        if (operator[0] > 0) {
            operator[0]--;
            backtrack(idx + 1, res + num[idx]);
            operator[0]++;
        }
 
        if (operator[1] > 0) {
            operator[1]--;
            backtrack(idx + 1, res - num[idx]);
            operator[1]++;
        }
 
        if (operator[2] > 0) {
            operator[2]--;
            backtrack(idx + 1, res * num[idx]);
            operator[2]++;
        }
 
        if (operator[3] > 0) {
            operator[3]--;
            backtrack(idx + 1, res / num[idx]);
            operator[3]++;
        }
    }
}
