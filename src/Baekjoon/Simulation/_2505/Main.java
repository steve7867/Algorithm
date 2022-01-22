/**
 * 두 번 뒤집기
 * https://www.acmicpc.net/problem/2505
 */
package Baekjoon.Simulation._2505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        if (isSorted(arr)) {
            System.out.println("1 1\n1 1");
            return;
        }

        int[] p = forward(arr);
        if (p != null) {
            System.out.printf("%d %d\n%d %d%n", p[0], p[1], p[2], p[3]);
            return;
        }

        p = backward(arr);
        System.out.printf("%d %d\n%d %d%n", p[0], p[1], p[2], p[3]);
    }

    private static int[] backward(int[] param) {
        int[] arr = Arrays.copyOf(param, param.length);
        int n = arr.length - 1;

        int r = n;
        while (arr[r] == r)
            r--;

        int l = r;
        while (arr[l] != r)
            l--;

        reverse(arr, l, r);
        if (isSorted(arr))
            return new int[]{l, r, 1, 1};

        int[] ret = new int[]{l, r, 0, 0};

        while (arr[r] == r)
            r--;

        l = r;
        while (arr[l] != r)
            l--;

        reverse(arr, l, r);
        if (isSorted(arr)) {
            ret[2] = l;
            ret[3] = r;

            return ret;
        }

        return null;
    }

    private static int[] forward(int[] param) {
        int[] arr = Arrays.copyOf(param, param.length);

        int l = 1;
        while (arr[l] == l)
            l++;

        int r = l;
        while (arr[r] != l)
            r++;

        reverse(arr, l, r);
        if (isSorted(arr))
            return new int[]{l, r, 1, 1};

        int[] ret = new int[]{l, r, 0, 0};

        while (arr[l] == l)
            l++;

        r = l;
        while (arr[r] != l)
            r++;

        reverse(arr, l, r);
        if (isSorted(arr)) {
            ret[2] = l;
            ret[3] = r;

            return ret;
        }

        return null;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != 1)
                return false;
        }

        return true;
    }

    private static void reverse(int[] arr, int l, int r) {
        int temp;
        while (l < r) {
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}