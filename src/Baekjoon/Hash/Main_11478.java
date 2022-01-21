/**
 * 서로 다른 부분 문자열의 개수
 * https://www.acmicpc.net/problem/11478
 * 문제 해설: https://entrydeveloper.tistory.com/522
 */
package Baekjoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Set<String> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++)
            for (int j = i + 1; j <= s.length(); j++)
                set.add(s.substring(i, j));

        System.out.println(set.size());
    }
}