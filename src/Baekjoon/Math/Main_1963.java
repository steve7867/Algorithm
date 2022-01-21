/**
 * 소수 경로
 * https://www.acmicpc.net/problem/1963
 */
package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_1963 {
    public static void main(String[] args) throws IOException {
        boolean[] isPrime = sieve();
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int[] tenSquare = {1, 10, 100, 1000};
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
 
            int minPath = getMinPath(src, dest, isPrime, tenSquare);
            if (minPath == -1)
                sb.append("Impossible");
            else
                sb.append(minPath);
 
            sb.append('\n');
        }
 
        System.out.println(sb);
    }
 
    private static int getMinPath(int src, int dest, boolean[] isPrime, int[] tenSquare) {
        int[] dist = new int[10000];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
 
        q.offer(src);
        dist[src] = 0;
 
        while (!q.isEmpty()) {
            int cur = q.poll();
 
            if (cur == dest)
                return dist[cur];
 
            int[] digit = getDigit(cur);
 
            for (int i = 0; i < 4; i++) {
                int temp = cur;
                temp -= digit[i] * tenSquare[i];
 
                for (int j = (i == 3) ? 1 : 0; j <= 9; j++) {
                    int next = temp + j * tenSquare[i];
                    if (!isPrime[next] || dist[next] >= 0)
                        continue;
 
                    q.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }
 
        return -1;
    }
 
    private static int[] getDigit(int num) {
        // 0:1의 자리
        // 1:10의 자리
        // 2:100의 자리
        // 3:1000의 자리
        int[] digit = new int[4];
        for (int i = 0; i < 4; i++) {
            digit[i] = num % 10;
            num /= 10;
        }
 
        return digit;
    }
 
    private static boolean[] sieve() {
        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
 
        for (int i = 2; i * i <= 10000; i++) {
            if (!isPrime[i])
                continue;
 
            for (int j = i * i; j <= 10000; j += i)
                isPrime[j] = false;
        }
 
        return isPrime;
    }
}
