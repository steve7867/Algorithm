/**
 * 암호 만들기
 * https://www.acmicpc.net/problem/1759
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_1759 {
    static int l, c;
    static char[] arr;
    static boolean[] isChosen;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        isChosen = new boolean[c];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++)
            arr[i] = st.nextToken().charAt(0);
 
        Arrays.sort(arr);
        backtrack(0, 0);
    }
 
    private static void backtrack(int idx, int chosen) {
        if (chosen == l) {
            StringBuilder sb = new StringBuilder();
            int vowel = 0, consonant = 0;
 
            for (int i = 0; i < c; i++) {
                if (isChosen[i]) {
                    sb.append(arr[i]);
 
                    if (isVowel(arr[i]))
                        vowel++;
                    else
                        consonant++;
                }
            }
 
            if (vowel >= 1 && consonant >= 2)
                System.out.println(sb);
 
            return;
        }
 
        if (idx == c)
            return;
 
        isChosen[idx] = true;
        backtrack(idx + 1, chosen + 1);
        isChosen[idx] = false;
 
        backtrack(idx + 1, chosen);
    }
 
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

//순서
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int l, c;
//    static char[] arr;
//    static boolean[] isChosen;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        l = Integer.parseInt(st.nextToken());
//        c = Integer.parseInt(st.nextToken());
//        arr = new char[c];
//        isChosen = new boolean[c];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < c; i++)
//            arr[i] = st.nextToken().charAt(0);
//
//        Arrays.sort(arr);
//        backtrack(0, 0);
//    }
//
//    private static void backtrack(int start, int chosen) {
//        if (chosen == l) {
//            StringBuilder sb = new StringBuilder();
//            int vowel = 0, consonant = 0;
//
//            for (int i = 0; i < c; i++) {
//                if (isChosen[i]) {
//                    sb.append(arr[i]);
//
//                    if (isVowel(arr[i]))
//                        vowel++;
//                    else
//                        consonant++;
//                }
//            }
//
//            if (vowel >= 1 && consonant >= 2)
//                System.out.println(sb);
//
//            return;
//        }
//
//        if (start == c)
//            return;
//
//        for (int i = start; i < c; i++) {
//            isChosen[i] = true;
//            backtrack(i + 1, chosen + 1);
//            isChosen[i] = false;
//        }
//    }
//
//    private static boolean isVowel(char c) {
//        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
//    }
//}
