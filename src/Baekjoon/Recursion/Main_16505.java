/**
 * 별
 * https://www.acmicpc.net/problem/16505
 */
package Baekjoon.Recursion;

import java.util.Scanner;
 
public class Main_16505 {
    static char[][] arr;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
 
        arr = new char[1<<N][1<<N];
        
        star(0, 0, N);
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String temp = "";
            for (int j = 0; j < arr[i].length; j++) {
                //null 문자일 경우
                if (arr[i][j] == Character.MIN_VALUE) arr[i][j] = ' ';
                temp += arr[i][j];
            }
            sb.append(temp.trim());
            sb.append('\n');
        }
        System.out.print(sb);
    }
 
    static void star(int x, int y, int N) {
        if (N == 0) {
            arr[x][y] = '*';
            return;
        }
        
        int size = 1<<(N-1);
        star(x, y, N-1);
        star(x, y+size, N-1);
        star(x+size, y, N-1);
    }
}