/**
 * 숫자 야구
 * https://www.acmicpc.net/problem/2503
 * 백트래킹으로 풀 수도 있다
 */
package Baekjoon.Brute_Force;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main_2503 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n;
    private static List<Answer> list = new LinkedList<Answer>();
    private static List<Integer> list2 = new LinkedList<Integer>();
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            Answer answer = new Answer(query, strike, ball);
            list.add(answer);
        }
        
        filter();
        
        int ans = list2.size();
        System.out.println(ans);
    }
    
    private static void filter() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;
                for (int k = 1; k <= 9; k++) {
                    if (i == k || j == k) continue;
                    int num = i * 100 + j * 10 + k;
                    boolean possible = true;
                    for (Answer answer : list) {
                        if(!isPossible(num, answer)) {
                            possible = false;
                            break;
                        }
                    }
                    if (possible) list2.add(num);
                }
            }
        }
    }
 
    private static boolean isPossible(int num, Answer ans) {
        int query = ans.query;
        int strike = ans.strike;
        int ball = ans.ball;
        
        int[] d1 = new int[3], d2 = new int[3];
        for (int i = 0; i < 3; i++) {
            d1[i] = num % 10;
            d2[i] = query % 10;
            num /= 10;
            query /= 10;
        }
        
        int s = 0, b = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (d1[i] == d2[j]) {
                    if (i == j) s++;
                    else b++;
                }
            }
        }
        
        return s == strike && b == ball;
    }
    
}
 
class Answer {
    int query;
    int strike;
    int ball;
    
    Answer(int query, int strike, int ball) {
        this.query = query;
        this.strike = strike;
        this.ball = ball;
    }
}