/**
 * N-Queen
 * https://www.acmicpc.net/problem/9663
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int answer;
    private static boolean[] isUsed1, isUsed2, isUsed3;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        isUsed1 = new boolean[n];
        isUsed2 = new boolean[(n - 1) * 2 + 1];
        isUsed3 = new boolean[(n - 1) * 2 + 1];
        
        func(0);
        
        System.out.println(answer);
    }
    
    private static void func(int x) {
        if (x == n) {
            answer++;
            return;
        }
        
        for (int y = 0; y < n; y++) {
            if (!isUsed1[y] && !isUsed2[x + y] && !isUsed3[x - y + n - 1]) {
                isUsed1[y] = true;
                isUsed2[x + y] = true;
                isUsed3[x - y + n - 1] = true;
                func(x + 1);
                isUsed1[y] = false;
                isUsed2[x + y] = false;
                isUsed3[x - y + n - 1] = false;
            }
        }
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//
//    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    private static int n;
//
//    public static void main(String[] args) throws IOException {
//            n = Integer.parseInt(br.readLine());
//            int[] answer = { 0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596 };
//            System.out.println(answer[n]);
//    }
//}