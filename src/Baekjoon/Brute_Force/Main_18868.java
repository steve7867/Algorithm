/**
 * 멀티버스 Ⅰ
 * https://www.acmicpc.net/problem/18868
 * 좌표 압축을 이용해 푸는 게 맞지만 데이터 사이즈가 작아서 브루트 포스로도 풀린다.
 */
package Baekjoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main_18868 {
    private static int M, N;
    private static int[][] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
 
        arr = new int[M][N];
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
 
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
 
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int k = 0; k < N; k++) {
                    if (j == k)
                        continue;
 
                    if (arr[i][j] > arr[i][k])
                        cnt++;
                }
 
                sb.append(cnt).append(' ');
            }
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
 
        int ans = 0;
        for (int val : map.values())
                ans += sumSequence(val);
 
        System.out.println(ans);
    }
 
    public static int sumSequence(int val) {
        return val * (val - 1) / 2;
    }
}
