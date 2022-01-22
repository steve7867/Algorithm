/**
 * 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 */
package Baekjoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_1182 {
    static int n, s;
    static int[] arr;
    static int ans;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
 
        backtrack(0, 0, 0);
        System.out.println(ans);
    }
 
    private static void backtrack(int i, int sum, int selected) {
        if (i == n) {
            if (selected > 0 && sum == s)
                ans++;
            return;
        }
 
        backtrack(i + 1, sum + arr[i], selected + 1);
        backtrack(i + 1, sum, selected);
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    private static int n, s;
//    private static int[] nums;
//    private static int cnt;
//    private static List<Integer> list = new LinkedList<>();
//
//    public static void main(String[] args) throws IOException {
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        s = Integer.parseInt(st.nextToken());
//        nums = new int[n];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++)
//            nums[i] = Integer.parseInt(st.nextToken());
//
//        backTrack(0, 0);
//
//        System.out.println(cnt);
//    }
//
//    private static void backTrack(int start, int sum) {
//        if (sum == s && list.size() >= 1) cnt++;
//
//        for (int i = start; i < nums.length; i++) {
//            list.add(nums[i]);
//            backTrack(i + 1, sum + nums[i]);
//            list.remove(list.size() - 1);
//        }
//    }
//}