/**
 * 휴게소 세우기
 * https://www.acmicpc.net/problem/1477
 *
 * 문제 해설: https://entrydeveloper.tistory.com/552
 */
package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1477 {

    private static int m;
    private static int[] term;
    private static int last;

    public static void main(String[] args) throws IOException {
        input();

        int st = 1, en = last;
        while (st < en) {
            int mid = (st + en) / 2;
            int num = getNum(mid);
            if (num <= m)
                en = mid;
            else
                st = mid + 1;
        }

        System.out.println(st);
    }

    private static int getNum(int mid) {
        int ret = 0;
        for (int t : term)
            ret += t / mid;

        return ret;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        last = stoi(st.nextToken());

        int[] arr = new int[n + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = stoi(st.nextToken());
        arr[n + 1] = last;

        Arrays.sort(arr);

        term = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++)
            term[i - 1] = arr[i] - arr[i - 1] - 1;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}