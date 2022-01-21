/**
 * 하노이 탑 이동 순서
 * https://www.acmicpc.net/problem/11729
 */
package Baekjoon.Recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main_11729 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        
        int n = Integer.parseInt(br.readLine());
        bw.write((1 << n) - 1 + "\n");
        func(1, 3, n);
        bw.flush();
    }
 
    //원판 n개를 a번 기둥에서 b번 기둥으로 옯기는 방법을 출력하는 함수
    private static void func(int a, int b, int n) throws IOException {
        if (n == 1) {
            bw.write(a + " " + b + "\n");
            return;
        }
        
        func(a, 6 - a - b, n - 1);
        bw.write(a + " " + b + "\n");
        func(6 - a - b, b, n - 1);
    }
}
