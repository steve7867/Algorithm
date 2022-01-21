/**
 * 창고 다각형
 * https://www.acmicpc.net/problem/2304
 * 문제 해설: https://entrydeveloper.tistory.com/441?category=1255793
 */
package Baekjoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Main_2304 {
    private static int n;
    private static int[] bars = new int[1001];
    private static Deque<Integer> leftSt = new ArrayDeque<>();
    private static Deque<Integer> rightSt = new ArrayDeque<>();
    private static int mxIdx = 0;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            bars[l] = h;
 
            if (bars[mxIdx] < bars[l])
                mxIdx = l;
        }
 
        for (int i = 0; i < mxIdx; i++) {
            if (leftSt.isEmpty())
                leftSt.push(bars[i]);
            else if (bars[i] > leftSt.peek())
                leftSt.push(bars[i]);
            else
                leftSt.push(leftSt.peek());
        }
 
        for (int i = 1000; i > mxIdx; i--) {
            if (rightSt.isEmpty())
                rightSt.push(bars[i]);
            else if (bars[i] > rightSt.peek())
                rightSt.push(bars[i]);
            else
                rightSt.push(rightSt.peek());
        }
 
        int width = bars[mxIdx];
        while (!leftSt.isEmpty())
            width += leftSt.pop();
 
        while (!rightSt.isEmpty())
            width += rightSt.pop();
 
        System.out.println(width);
    }
}