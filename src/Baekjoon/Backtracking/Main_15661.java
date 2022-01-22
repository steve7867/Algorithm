/**
 * 링크와 스타트
 * https://www.acmicpc.net/problem/15661
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_15661 {
    static int n;
    static int[][] board;
    static boolean[] isIncluded;
    static int ans = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        isIncluded = new boolean[n];
 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        backtrack(0, 0);
        System.out.println(ans);
    }
 
    private static void backtrack(int idx, int included) {
        if (idx == n) {
            if (included == 0 && included == n)
                return;
 
            int team1 = 0, team2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isIncluded[i] && isIncluded[j])
                        team1 += board[i][j];
                    else if (!isIncluded[i] && !isIncluded[j])
                        team2 += board[i][j];
                }
            }
 
            ans = Math.min(ans, Math.abs(team1 - team2));
            return;
        }
 
        isIncluded[idx] = true;
        backtrack(idx + 1, included + 1);
        isIncluded[idx] = false;
 
        backtrack(idx + 1, included);
    }
}

//다른풀이
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int n;
//    static int[][] board;
//    static boolean[] isIncluded;
//    static int ans = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        board = new int[n][n];
//        isIncluded = new boolean[n];
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                board[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int target = 1; target <= n; target++)
//            backtrack(target, 0, 0);
//
//        System.out.println(ans);
//    }
//
//    private static void backtrack(int target, int start, int included) {
//        if (included == target) {
//            int team1 = 0, team2 = 0;
//
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (isIncluded[i] && isIncluded[j])
//                        team1 += board[i][j];
//                    else if (!isIncluded[i] && !isIncluded[j])
//                        team2 += board[i][j];
//                }
//            }
//
//            ans = Math.min(ans, Math.abs(team1 - team2));
//
//            return;
//        }
//
//        for (int i = start; i < n; i++) {
//            isIncluded[i] = true;
//            backtrack(target, i + 1, included + 1);
//            isIncluded[i] = false;
//        }
//    }
//}