/**
 * 랜선 자르기
 * https://www.acmicpc.net/problem/1654
 *
 * 변수들을 long 타입으로 선언한 건 st + en이 int의 범위를 넘어설 수도 있기 때문이다.
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;
 
public class Main_1654 {
    private static int k, n;
    private static int[] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
 
        k = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[k];
 
        for (int i = 0; i < k; i++)
            arr[i] = Integer.parseInt(br.readLine());
 
        long st = 1L, en = Integer.MAX_VALUE;
        while (st < en) {
            long mid = (st + en + 1) / 2;
 
            if (check(mid))
                st = mid;
            else
                en = mid - 1;
        }
 
        System.out.println(st);
    }
 
    private static boolean check(long len) {
        long cnt = 0;
        for (int lan : arr)
            cnt += lan / len;
 
        return cnt >= n;
    }
}
