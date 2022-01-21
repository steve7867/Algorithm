/**
 * 무한 수열
 * https://www.acmicpc.net/problem/1351
 */
package Baekjoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main_1351 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Map<Long, Long> map = new HashMap<>();
    private static long p;
    private static long q;
 
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
 
        System.out.println(dp(n));
    }
 
    private static long dp(long i) {
        if (i == 0)
            return 1;
 
        if (map.containsKey(i))
            return map.get(i);
 
        long ret = dp(i / p) + dp(i / q);
 
        map.put(i, ret);
        return ret;
    }
}
