package Baekjoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        long r = s;
        long cnt = 0;
        for (long l = 1; l < s; l++) {
            r = r - l;
            if (r <= l)
                break;
            cnt++;
        }

        System.out.println(cnt + 1);
    }
}