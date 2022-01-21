/**
 * 체스판 다시 칠하기
 * https://www.acmicpc.net/problem/1018
 */
package Baekjoon.Brute_Force;

import java.io.*;
import java.util.*;

public class Main_1018 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, M;
    private static char[][] board;
    private static char[][] chess = new char[8][8];
    private static char[][] white = new char[8][8]; //첫번째 칸이 흰색인 체스판
    private static int ans = Integer.MAX_VALUE;
    
    static {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++)
                white[r][c] = r % 2 == c % 2 ? 'W' : 'B';
        }
    }
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++)
            board[i] = br.readLine().toCharArray();
        
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                for (int k = 0; k < 8; k++)
                    chess[k] = Arrays.copyOfRange(board[k + i], j, j + 8);
                
                ans = Math.min(ans, getMinDiff());
            }
        }
        
        System.out.println(ans);
    }

    private static int getMinDiff() {
        // 첫번째 칸이 화이트인 체스판과 불일치하는 개수 == 첫번째 칸이 블랙인 체스판과 일치하는 개수 
        int cnt = 0; 
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                if (chess[i][j] != white[i][j]) cnt++;
        }
        
        return Math.min(cnt, 64 - cnt);
    }
    
}