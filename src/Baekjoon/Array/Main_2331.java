//https://www.acmicpc.net/problem/2331
package Baekjoon.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main_2331 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int A, P;
    private static int[] idx = new int[250000];

    static {
        Arrays.fill(idx, -1);
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        idx[A] = 0;

        int i = 1;
        while (true) {
            A = makeNum(A);
            if (idx[A] > -1) break;
            idx[A] = i;
            i++;
        }
        
        System.out.println(idx[A]);
    }

    private static int makeNum(int A) {
        int ret = 0;
        while (A > 0) {
            int remainder = A % 10;
            ret += (int)Math.pow(remainder, P);
            A /= 10;
        }

        return ret;
    }
}