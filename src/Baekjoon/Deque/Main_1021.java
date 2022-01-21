/**
 * 회전하는 큐
 * https://www.acmicpc.net/problem/1021
 * 문제 해설: https://entrydeveloper.tistory.com/208?category=1186788
 */
package Baekjoon.Deque;

import java.io.*;
import java.util.*;

public class Main_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int MX = 10000;
        int[] dq = new int[2 * MX + 1];
        int head = MX, tail = MX;
        int N = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++)
            dq[tail++] = i;
        
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        int cnt = 0;
        while (M-- > 0) {
            int next = Integer.parseInt(st.nextToken());
            int mid = (tail + head) / 2;
            int idx = indexOf(dq, next);
            if (idx <= mid) {
                while (dq[head] != next) {
                    dq[tail++] = dq[head];
                    dq[head++] = 0;
                    cnt++;
                }
            } else {
                while (dq[head] != next) {
                    dq[--head] = dq[tail - 1];
                    dq[tail--] = 0;
                    cnt++;
                }
            }
            
            head++;
        }
        
        System.out.println(cnt);
        br.close();
    }
    
    public static int indexOf(int[] arr, int num) {
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                idx = i;
                break;
            }
        }
        
        return idx;
    }
}