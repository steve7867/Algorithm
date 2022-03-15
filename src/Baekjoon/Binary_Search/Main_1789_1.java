package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        long l = 1L;
        long r = s;

        while (l < r) {
            long mid = (l + r + 1) / 2;
            long val = mid * (mid + 1) / 2;
            if (val <= s)
                l = mid;
            else
                r = mid - 1;
        }

        System.out.println(l);
    }
}