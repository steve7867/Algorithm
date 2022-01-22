/**
 * N과 M (10)
 * https://www.acmicpc.net/problem/15664
 */
package Baekjoon.Backtracking.N_and_M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main10 {
    static int n, m;
    static int[] arr, remainder;
    static int max = 1;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        remainder = new int[10001];
        arr = new int[m];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int n = Integer.parseInt(st.nextToken());
            remainder[n]++;
 
            max = Math.max(max, n);
        }
 
        backtrack(0, 1);
        System.out.println(sb);
    }
 
    private static void backtrack(int idx, int start) {
        if (idx == m) {
            for (int i = 0; i < arr.length; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
 
        for (int i = start; i <= max; i++) {
            if (remainder[i] == 0)
                continue;
            arr[idx] = i;
            remainder[i]--;
            backtrack(idx + 1, i);
            remainder[i]++;
        }
    }
 
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int n, m;
//    static int[] arr, remainder;
//    static int max = 1;
//    static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        remainder = new int[10001];
//        arr = new int[m];
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            int n = Integer.parseInt(st.nextToken());
//            remainder[n]++;
//
//            max = Math.max(max, n);
//        }
//
//        backtrack(1, 0);
//        System.out.println(sb);
//    }
//
//    private static void backtrack(int num, int idx) {
//        if (idx == m) {
//            for (int j = 0; j < arr.length; j++)
//                sb.append(arr[j]).append(" ");
//            sb.append("\n");
//            return;
//        }
//
//        if (num == max + 1)
//            return;
//
//        if (remainder[num] > 0) {
//            arr[idx] = num;
//            remainder[num]--;
//            backtrack(num, idx + 1);
//            remainder[num]++;
//        }
//
//        backtrack(num + 1, idx);
//    }
//}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	private static StringTokenizer st;
//	private static StringBuilder sb = new StringBuilder();
//	private static int N, M;
//	private static int[] nums;
//	private static int[] arr;
//	private static boolean[] isUsed;
//
//	public static void main(String[] args) throws IOException {
//		st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		arr = new int[M];
//		nums = new int[N];
//
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++)
//			nums[i] = Integer.parseInt(st.nextToken());
//		Arrays.sort(nums);
//
//		backTrack(0, 0);
//		System.out.println(sb);
//	}
//
//	private static void backTrack(int k, int start) {
//		if (k == M) {
//			for (int i : arr)
//				sb.append(i).append(" ");
//			sb.append("\n");
//			return;
//		}
//
//		for (int i = start; i < N; i++) {
//			if (i > start && nums[i] == nums[i - 1]) continue;
//			arr[k] = nums[i];
//			backTrack(k + 1, i + 1);
//		}
//	}
//
//}