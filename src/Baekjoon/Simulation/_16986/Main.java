/**
 * 인싸들의 가위바위보
 * https://www.acmicpc.net/problem/16986
 */
package Baekjoon.Simulation._16986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, K;
    private static int[][] table; // 상성표
    private static boolean[] occur; // 지우가 냈던 손동작
    private static final int[] kh = new int[20];
    private static final int[] mh = new int[20];
 
    public static void main(String[] args) throws IOException {
        input();
 
        boolean exist = check(0, 0, 0, 0, 0, new int[]{0, 1});
        System.out.println(exist ? 1 : 0);
    }
 
    // gw: 지우가 이긴 횟수
    // kw: 경희가 이긴 횟수
    // mw: 민호가 이긴 횟수
    // kp: 경희가 내야할 손동작을 가리키는 포인터
    // mp: 민호가 내야할 손동작을 가리키는 포인터
    // p: 다음에 대결하는 두 사람 (0: 지우, 1: 경희, 2: 민호)
    // 지우가 이기는 경우가 존재하는지 check
    private static boolean check(int gw, int kw, int mw, int kp, int mp, int[] p) {
        if (gw == K || kw == K || mw == K)
            return gw == K;
 
        if (p[0] == 1 && p[1] == 2) {
            int res = table[kh[kp]][mh[mp]];
 
            if (res == 2) {
                p[0] = 0;
                p[1] = 1;
                return check(gw, kw + 1, mw, kp + 1, mp + 1, p);
            } else {
                p[0] = 0;
                p[1] = 2;
                return check(gw, kw, mw + 1, kp + 1, mp + 1, p);
            }
        }
 
        boolean isKH = (p[1] == 1); //한명은 지우, 다른 한명이 경희인지 민호인지
 
        for (int i = 0; i < N; i++) {
            if (occur[i])
                continue;
 
            occur[i] = true;
            int res = isKH ? table[i][kh[kp]] : table[i][mh[mp]];
 
            boolean exist;
            if (res == 2) {
                if (isKH) {
                    p[0] = 0;
                    p[1] = 2;
                    exist = check(gw + 1, kw, mw, kp + 1, mp, p);
                } else {
                    p[0] = 0;
                    p[1] = 1;
                    exist = check(gw + 1, kw, mw, kp, mp + 1, p);
                }
            } else {
                p[0] = 1;
                p[1] = 2;
                if (isKH)
                    exist = check(gw, kw + 1, mw, kp + 1, mp, p);
                else
                    exist = check(gw, kw, mw + 1, kp, mp + 1, p);
            }
 
            if (exist)
                return true;
 
            occur[i] = false;
        }
 
        return false;
    }
 
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
 
        table = new int[N][N];
        occur = new boolean[N];
 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++)
            kh[i] = Integer.parseInt(st.nextToken()) - 1;
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++)
            mh[i] = Integer.parseInt(st.nextToken()) - 1;
    }
}
