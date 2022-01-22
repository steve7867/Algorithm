/**
 * 톱니바퀴
 * https://www.acmicpc.net/problem/14891
 */
package Baekjoon.Simulation._14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int[][] sawtooth = new int[5][8];
    static final int CLOCK_WISE = 1;
    static final int COUNTER_CLOCK_WISE = -1;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                sawtooth[i][j] = input.charAt(j) - '0';
            }
        }
 
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            process(idx, dir);
        }
 
        System.out.println(getScore());
    }
 
    private static void process(int idx, int dir) {
        boolean[] shouldRotate = new boolean[5];
        shouldRotate[idx] = true;
 
        for (int i = idx - 1; i >= 1; i--) {
            if (shouldRotate[i + 1] && sawtooth[i][2] != sawtooth[i + 1][6])
                shouldRotate[i] = true;
        }
 
        for (int i = idx + 1; i <= 4; i++) {
            if (shouldRotate[i - 1] && sawtooth[i - 1][2] != sawtooth[i][6])
                shouldRotate[i] = true;
        }
 
        for (int i = 1; i <= 4; i++) {
            if (shouldRotate[i]) {
                int temp = idx - i;
                if (temp == 0 || temp == -2 || temp == 2)
                    rotate(i, dir);
                else
                    rotate(i, -dir);
            }
        }
    }
 
    private static int getScore() {
        int ans = 0;
        for (int i = 1; i <= 4; i++) {
            if (sawtooth[i][0] == 1)
                ans += 1 << (i - 1);
        }
        return ans;
    }
 
    private static void rotate(int idx, int dir) {
        if (dir == CLOCK_WISE) {
            int temp = sawtooth[idx][7];
            for (int i = 6; i >= 0; i--)
                sawtooth[idx][i + 1] = sawtooth[idx][i];
 
            sawtooth[idx][0] = temp;
        } else if (dir == COUNTER_CLOCK_WISE) {
            int temp = sawtooth[idx][0];
            for (int i = 1; i <= 7; i++)
                sawtooth[idx][i - 1] = sawtooth[idx][i];
 
            sawtooth[idx][7] = temp;
        }
    }
}