/**
 * 덱
 * https://www.acmicpc.net/problem/10866
 */
package Baekjoon.Deque;

import java.io.*;
import java.util.*;
 
public class Main_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        
        while (N-- > 0) {
            String s = br.readLine();
            
            if (s.startsWith("push")) {
                if (s.substring(5).startsWith("front")) dq.offerFirst(s.substring(11));
                else dq.offerLast(s.substring(10));
            } else {
                if (s.startsWith("pop")) {
                    if (s.substring(4).startsWith("front")) bw.write(dq.isEmpty() ? "-1" : dq.pollFirst());
                    else bw.write(dq.isEmpty() ? "-1" : dq.pollLast());
                } else if (s.startsWith("size")) {
                    bw.write(dq.size() + "");
                } else if (s.startsWith("empty")) {
                    bw.write(dq.isEmpty() ? "1" : "0");
                } else if (s.startsWith("front")) {
                    bw.write(dq.isEmpty() ? "-1" : dq.peekFirst() + "");
                } else if (s.startsWith("back")) {
                    bw.write(dq.isEmpty() ? "-1" : dq.peekLast() + "");
                }
                bw.write("\n");
            }
            
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

//배열을 활용한 풀이
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int MX = 10000;
//        String[] dq = new String[2 * MX + 1];
//        int head = MX, tail = MX;
//        int N = Integer.parseInt(br.readLine());
//
//        while (N-- > 0) {
//            String s = br.readLine();
//
//            if (s.startsWith("push")) {
//                if (s.substring(5).startsWith("front")) dq[--head] = s.substring(11);
//                else dq[tail++] = s.substring(10);
//            } else {
//                if (s.startsWith("pop")) {
//                    if (s.substring(4).startsWith("front")) bw.write(head == tail ? "-1" : dq[head++]);
//                    else bw.write(head == tail ? "-1" : dq[(tail--) - 1]);
//                } else if (s.startsWith("size")) {
//                    bw.write(tail - head + "");
//                } else if (s.startsWith("empty")) {
//                    bw.write(head == tail ? "1" : "0");
//                } else if (s.startsWith("front")) {
//                    bw.write(head == tail ? "-1" : dq[head] + "");
//                } else if (s.startsWith("back")) {
//                    bw.write(head == tail ? "-1" : dq[tail - 1] + "");
//                }
//                bw.write("\n");
//            }
//
//        }
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}
