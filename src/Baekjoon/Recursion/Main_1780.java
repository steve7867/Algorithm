/**
 * 종이의 개수
 * https://www.acmicpc.net/problem/1780
 */
package Baekjoon.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_1780 {
    
    static int[][] map;
    static int[] record = new int[3]; //idx 0, 1, 2에 각각 -1, 0, 1의 개수를 기록.
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        func(n, 0, 0);
        
        System.out.println(record[0]);
        System.out.println(record[1]);
        System.out.println(record[2]);
    }
    
    // (x, y)를 기점으로 하는 n * n 정사각형의 종이 개수를 계산하여 record에 기록
    private static void func(int n, int x, int y) {
        
        boolean isSame = true;
        
        outer:
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (map[x][y] != map[i][j]) {
                    isSame = false;
                    break outer;
                }
            }
        }
        
        //base condition
        if (isSame) {
            record[map[x][y] + 1]++;
            return;
        }
        
        int len = n / 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                func(len, x + i * len, y + j * len);
        
    }
}
