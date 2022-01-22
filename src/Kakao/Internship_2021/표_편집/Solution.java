/**
 * 표 편집
 * https://programmers.co.kr/learn/courses/30/lessons/81303
 */
package Kakao.Internship_2021.표_편집;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
 
class Solution {
    int n, k;
    int[] upper, lower;
    boolean[] exist;
    Deque<Integer> stack = new ArrayDeque<>();
 
    public String solution(int N, int K, String[] cmd) {
        n = N;
        k = K;
        exist = new boolean[n];
        Arrays.fill(exist, true);
        upper = new int[n];
        lower = new int[n];
 
        upper[0] = 0;
        for (int i = 1; i < n; i++)
            upper[i] = i - 1;
 
        lower[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--)
            lower[i] = i + 1;
 
        for (String order : cmd) {
            String[] o = order.split(" ");
            switch (o[0]) {
                case "U":
                    U(Integer.parseInt(o[1]));
                    break;
                case "D":
                    D(Integer.parseInt(o[1]));
                    break;
                case "C":
                    C();
                    break;
                case "Z":
                    Z();
                    break;
            }
        }
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(exist[i] ? 'O' : 'X');
        return sb.toString();
    }
 
    private void Z() {
        int target = stack.pop();
        exist[target] = true;
 
        int up = target - 1;
        int down = target + 1;
 
        while (up >= 0 && !exist[up])
            up--;
 
        if (up  == -1)
            upper[target] = target;
        else {
            upper[target] = up;
            lower[up] = target;
        }
 
        while (down <= n - 1 && !exist[down])
            down++;
 
        if (down == n)
            lower[target] = target;
        else {
            lower[target] = down;
            upper[down] = target;
        }
    }
 
    private void C() {
        stack.push(k);
        exist[k] = false;
 
        if (k == upper[k]) {
            k = lower[k];
            upper[k] = k;
        } else if (k == lower[k]) {
            k = upper[k];
            lower[k] = k;
        } else {
            int up = upper[k];
            int down = lower[k];
            lower[up] = down;
            upper[down] = up;
            k = down;
        }
    }
 
    private void D(int x) {
        for (int i = 0; i < x; i++) {
            k = lower[k];
        }
    }
 
    private void U(int x) {
        for (int i = 0; i < x; i++) {
            k = upper[k];
        }
    }
}