/**
 * 반복수열
 * https://www.acmicpc.net/problem/2331
 */
package Baekjoon.LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main_2331 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int A, P;
    private static List<Integer> list = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        list.add(A);

        while (true) {
            A = makeNum(A);
            if (list.contains(A)) {
                System.out.println(list.indexOf(A));
                return;
            }
            list.add(A);
        }
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