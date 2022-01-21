/**
 * 쿼드트리
 * https://www.acmicpc.net/problem/1992
 */
package Baekjoon.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        
        for (int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();
        
        System.out.println(func(n, 0, 0));
    }
    // (x, y)를 기점으로 n * n 정사각형을 압축한 결과를 리턴.
    private static String func(int n, int x, int y) {
        if (n == 1) {
            return String.valueOf(map[x][y]);
        }
        
        int len = n / 2;
        String ret = "("; 
        ret += func(len, x, y); 
        ret += func(len, x, y + len); 
        ret += func(len, x + len, y); 
        ret += func(len, x + len, y + len);
        ret += ")";
        return ret.replace("(1111)", "1").replace("(0000)", "0");
    }
}