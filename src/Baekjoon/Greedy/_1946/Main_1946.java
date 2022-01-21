/**
 * 신입 사원
 * https://www.acmicpc.net/problem/1946
 */
package Baekjoon.Greedy._1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
 
        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());
            Pair[] arr = new Pair[N];
 
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
 
                arr[i] = new Pair(a, b);
            }
 
            Arrays.sort(arr);
 
            int ans = 1;
            int min = arr[0].b;
            for (int i = 1; i < N; i++) {
                if (arr[i].b < min) {
                    ans++;
                    min = arr[i].b;
                }
            }
 
            sb.append(ans)
                    .append('\n');
        }
        System.out.println(sb);
    }
}
 
class Pair implements Comparable<Pair> {
    int a;
    int b;
 
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
 
    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.a, o.a);
    }
}
