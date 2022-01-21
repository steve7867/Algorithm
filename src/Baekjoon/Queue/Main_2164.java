/**
 * 카드2
 * https://www.acmicpc.net/problem/2164
 */
package Baekjoon.Queue;

import java.io.*;
import java.util.*;
 
public class Main_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
 
        for (int i = 1; i <= N; i++)
            q.offer(i);
        
        while (q.size() > 1) {
            q.poll();
            q.offer(q.poll());
        }
        
        System.out.println(q.poll());
        br.close();
    }
}

//배열을 활용한 풀이
//
//import java.io.*;
//import java.util.*;
//
////public class Main {
////    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        int[] q = new int[1000000];
//        int head = 0, tail = 0;
//        int N = Integer.parseInt(br.readLine());
//
//        for (int i = 1; i <= N; i++)
//            q[tail++] = i;
//
//        while ((tail - head) > 1) {
//            head++;
//            q[tail++] = q[head++];
//        }
//
//        System.out.println(q[tail - 1]);
//        br.close();
//    }
//}