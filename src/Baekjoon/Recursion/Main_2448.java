/**
 * 별 찍기 - 11
 * https://www.acmicpc.net/problem/2448
 */
package Baekjoon.Recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_2448 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(map[i], ' ');
        
        func(n, 0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }
    
    // n * n의 패턴을 (x, y)를 기점으로 출력하는 함수
    private static void func(int n, int x, int y) {
        if (n == 1) {
            map[x][y] = '*';
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                func(n / 3, x + n / 3 * i, y + n / 3 * j);
            }
        }
    }
}