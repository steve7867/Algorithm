/**
 * 단어 정렬
 * https://www.acmicpc.net/problem/1181
 */
package Baekjoon.Sort1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main_1181 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static String[] arr;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        
        for (int i = 0; i < n; i++)
            arr[i] = br.readLine();
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int aLen = a.length(), bLen = b.length();
                if (aLen == bLen) return a.compareTo(b);
                return aLen - bLen;
            }
        });
        
        sb.append(arr[0]).append("\n");
        for (int i = 1; i < n; i++) {
            if (arr[i].equals(arr[i - 1])) continue;
            sb.append(arr[i]).append("\n");
        }
        
        System.out.println(sb);
    }
    
}

// 트리를 활용한 풀이
//import java.io.*;
//        import java.util.Comparator;
//        import java.util.TreeSet;
//
//public class Main {
//
//    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    private static TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
//        @Override
//        public int compare(String s1, String s2) {
//            if (s1.length() == s2.length()) return s1.compareTo(s2);
//            else return s1.length() - s2.length();
//        }
//    });
//
//    public static void main(String[] args) throws IOException {
//        int tc = Integer.parseInt(br.readLine());
//        while (tc-- > 0) {
//            String s = br.readLine();
//            ts.add(s);
//        }
//
//        for (String s : ts) bw.write(s + "\n");
//        bw.flush();
//    }
//
//}
