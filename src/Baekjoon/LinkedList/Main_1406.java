/**
 * 에디터
 * https://www.acmicpc.net/problem/1406
 * 문제 해설: https://entrydeveloper.tistory.com/195
 */
package Baekjoon.LinkedList;

import java.io.*;
import java.util.*;

public class Main_1406 {
    public static void main (String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        LinkedList<Character> list = new LinkedList<>();
        String s = br.readLine();
        for (char c : s.toCharArray())
            list.add(c);
        int cursor = list.size();
        
        int M = Integer.parseInt(br.readLine());
        
        while (M-- > 0) {
            String command = br.readLine();
            char c = command.charAt(0);
            switch (c) {
            case 'L':
                if (cursor != 0) cursor--;
                break;
            case 'D':
                if (cursor != list.size()-1) cursor++; 
                break;
            case 'B':
                if (cursor != 0)
                    list.remove(--cursor);
                break;
            case 'P':
                list.add(cursor++, command.charAt(2));
                break;
            }
        }
        
        for (char c : list)
            bw.write(c);
        
        bw.flush();
        bw.close();
        br.close();
    }
}