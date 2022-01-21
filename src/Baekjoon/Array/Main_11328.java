//https://www.acmicpc.net/problem/11328
package Baekjoon.Array;

import java.io.*;

public class Main_11328 {
    public static void main (String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            if (canMake(input[0], input[1])) 
                bw.write("Possible" + "\n");
            else 
                bw.write("Impossible" + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static boolean canMake(String first, String second) {
        if (first.length() != second.length()) 
            return false;
        int[] countArr = new int[26];
        
        for (char c : first.toCharArray()) 
            countArr[c - 'a']++;
        
        for (char c : second.toCharArray()) {
            if (countArr[c - 'a'] == 0) 
                return false;
            countArr[c - 'a']--;
        }
        
        return true;
    }
}