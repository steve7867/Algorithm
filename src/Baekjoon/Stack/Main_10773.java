/**
 * 제로
 * https://www.acmicpc.net/problem/10773
 */
package Baekjoon.Stack;

import java.io.*;
import java.util.Stack;
 
public class Main_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Stack<String> s = new Stack<>();
        int K = Integer.parseInt(br.readLine());
        
        while (K-- > 0) {
            String input = br.readLine();
            if (input.equals("0")) s.pop();
            else s.push(input);
        }
        
        int sum = 0;
        for (String item : s)
            sum += Integer.parseInt(item);
        
        System.out.println(sum);
        br.close();
    }
}
