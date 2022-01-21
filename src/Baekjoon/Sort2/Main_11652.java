/**
 * 카드
 * https://www.acmicpc.net/problem/11652
 */
package Baekjoon.Sort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main_11652 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static long[] arr;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i] = num;
        }
        
        Arrays.sort(arr);
        
        long anchor = arr[0];
        int cnt = 1;
        long mx = anchor;
        int mxCnt = cnt;
        
        for (int i = 1; i < n; i++) {
            if (anchor == arr[i]) cnt++;
            else {
                if (cnt > mxCnt) {
                    mx = anchor;
                    mxCnt = cnt;
                }
                
                anchor = arr[i];
                cnt = 1;
            }
        }
        
        if (cnt > mxCnt) {
            mx = anchor;
            mxCnt = cnt;
        }
        
        System.out.println(mx);
    }
 
}

//풀이(Map을 사용)
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Main {
//
//    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    private static int n;
//    private static Map<Long, Integer> map = new TreeMap<>();
//
//    public static void main(String[] args) throws IOException {
//        n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            long num = Long.parseLong(br.readLine());
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        long max = (Long) map.keySet().toArray()[0];
//        for (long num : map.keySet())
//            if (map.get(max) < map.get(num)) max = num;
//
//        System.out.println(max);
//    }
//
//}