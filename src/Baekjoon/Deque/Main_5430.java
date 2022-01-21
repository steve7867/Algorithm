/**
 * AC
 * https://www.acmicpc.net/problem/5430
 */
package Baekjoon.Deque;

import java.io.*;
import java.util.*;
 
public class Main_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<String> dq = new LinkedList<>();
            
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            while (st.hasMoreTokens())
                dq.offer(st.nextToken());
            
            boolean isReverse = false;
            boolean isError = false;
            for (char c : p.toCharArray()) {
                if (c == 'R')
                    isReverse = !isReverse;
                else if (c == 'D') {
                    if (dq.isEmpty()) {
                        isError = true;
                        continue;
                    }
                    
                    if (isReverse) dq.pollLast();
                    else dq.pollFirst();
                }
            }
            
            if (isError)
                System.out.println("error");
            else {
                StringBuffer sb = new StringBuffer("[");
                
                if (dq.isEmpty()) sb.append("]");
                else {
                    if (isReverse) {
                        while (!dq.isEmpty()) 
                            sb.append(dq.pollLast() + ",");
                    } else {
                        while (!dq.isEmpty())
                            sb.append(dq.pollFirst() + ",");
                    }
                    sb.setCharAt(sb.length() - 1, ']');
                }
                
                System.out.println(sb);
            }
        }
        
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
//
//        int T = Integer.parseInt(br.readLine());
//
//        while (T-- > 0) {
//            String p = br.readLine();
//            int n = Integer.parseInt(br.readLine());
//            String[] dq = new String[200001];
//            int head = 100000, tail = 100000;
//
//            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
//            while (st.hasMoreTokens())
//                dq[tail++] = st.nextToken();
//
//            boolean isReverse = false;
//            boolean isError = false;
//            for (char c : p.toCharArray()) {
//                if (c == 'R')
//                    isReverse = !isReverse;
//                else if (c == 'D') {
//                    if (head == tail) {
//                        isError = true;
//                        continue;
//                    }
//
//                    if (isReverse) tail--;
//                    else head++;
//                }
//            }
//
//            if (isError)
//                System.out.println("error");
//            else {
//                StringBuffer sb = new StringBuffer("[");
//
//                if (head == tail) sb.append("]");
//                else {
//                    if (isReverse) {
//                        while (!(head == tail))
//                            sb.append(dq[(tail--) - 1] + ",");
//                    } else {
//                        while (!(head == tail))
//                            sb.append(dq[head++] + ",");
//                    }
//                    sb.setCharAt(sb.length() - 1, ']');
//                }
//
//                System.out.println(sb);
//            }
//        }
//
//        br.close();
//    }
//}
