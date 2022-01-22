/**
 * N과 M (11)
 * https://www.acmicpc.net/problem/15665
 */
package Baekjoon.Backtracking.N_and_M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main11 {
    static int n, m;
    static int[] arr;
    static boolean[] occur;
    static int max = 1;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        occur = new boolean[10001];
        arr = new int[m];
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int n = Integer.parseInt(st.nextToken());
            occur[n] = true;
 
            max = Math.max(max, n);
        }
 
        backtrack(0);
        System.out.println(sb);
    }
 
    private static void backtrack(int idx) {
        if (idx == m) {
            for (int i = 0; i < arr.length; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
 
        for (int i = 1; i <= max; i++) {
            if (!occur[i])
                continue;
            arr[idx] = i;
            backtrack(idx + 1);
        }
    }
 
}

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
//		backTrack(0);
//		System.out.println(sb);
//	}
//
//	private static void backTrack(int k) {
//		if (k == M) {
//			for (int i : arr)
//				sb.append(i).append(" ");
//			sb.append("\n");
//			return;
//		}
//
//		for (int i = 0; i < N; i++) {
//			if (i > 0 && nums[i] == nums[i - 1]) continue;
//			arr[k] = nums[i];
//			backTrack(k + 1);
//		}
//	}
//
//}