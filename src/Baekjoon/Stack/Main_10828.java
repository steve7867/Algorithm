/**
 * 스택
 * https://www.acmicpc.net/problem/10828
 */
package Baekjoon.Stack;

import java.io.*;
import java.util.Stack;
 
public class Main_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Stack<String> s = new Stack<>();
        
        while (N-- > 0) {
            String input = br.readLine();
            
            //input.startsWith("push")도 가능
            if (input.contains("push"))       s.push(input.substring(5));
            else if (input.contains("pop"))   bw.write(s.isEmpty() ? "-1\n" : s.pop() + "\n");
            else if (input.contains("size"))  bw.write(s.size() + "\n");
            else if (input.contains("empty")) bw.write(s.isEmpty() ? "1\n" : "0\n");
            else if (input.contains("top"))   bw.write(s.isEmpty() ? "-1\n" : s.peek() + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
