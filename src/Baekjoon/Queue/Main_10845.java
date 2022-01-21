/**
 * 큐
 * https://www.acmicpc.net/problem/10845
 */
package Baekjoon.Queue;

import java.io.*;
import java.util.*;
 
public class Main_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<String> q = new LinkedList<String>();
        int N = Integer.parseInt(br.readLine());
 
        while (N-- > 0) {
            String s = br.readLine();
            if (s.contains("push")) {
                q.offer(s.substring(5));
            } else {
                if (s.contains("pop"))
                    bw.write(q.isEmpty() ? "-1" : q.poll());
                else if (s.contains("size"))
                    bw.write(q.size() + "");
                else if (s.contains("empty"))
                    bw.write(q.isEmpty() ? "1" : "0");
                else if (s.contains("front"))
                    bw.write(q.isEmpty() ? "-1" : q.peek());
                else if (s.contains("back"))
                    bw.write(q.isEmpty() ? "-1" : q.peekLast());
 
                bw.write("\n");
            }
        }
 
        bw.flush();
        bw.close();
        br.close();
    }
}

//배열을 활용한 풀이
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] q = new String[10001];
//        int head = 0, tail = 0;
//        int N = Integer.parseInt(br.readLine());
//
//        while (N-- > 0) {
//            String s = br.readLine();
//            if (s.contains("push")) {
//                q[tail++] = s.substring(5);
//            } else {
//                if (s.contains("pop"))
//                    bw.write(head == tail ? "-1" : q[head++]);
//                else if (s.contains("size"))
//                    bw.write((tail - head) + "");
//                else if (s.contains("empty"))
//                    bw.write(head == tail ? "1" : "0");
//                else if (s.contains("front"))
//                    bw.write(head == tail ? "-1" : q[head]);
//                else if (s.contains("back"))
//                    bw.write(head == tail ? "-1" : q[tail - 1]);
//
//                bw.write("\n");
//            }
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//}