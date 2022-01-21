/**
 * 나이순 정렬
 * https://www.acmicpc.net/problem/10814
 *
 * 퀵소트는 stable sort를 보장하지 않기 때문에 불가능
 */
package Baekjoon.Sort1.MergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_10814 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static Member[] arr, temp;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new Member[n];
        temp = new Member[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[i] = new Member(age, name);
        }
        
        mergeSort(0, n);
        
        for (Member m : arr)
            sb.append(m.age).append(" ").append(m.name).append("\n");
        
        System.out.println(sb);
    }
 
    private static void mergeSort(int st, int en) {
        if (st == en - 1) return;
        
        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }
 
    private static void merge(int st, int en) {
        System.arraycopy(arr, st, temp, st, en - st);
        
        int mid = (st + en) / 2;
        int aIdx = st;
        int bIdx = mid;
        
        for (int i = st; i < en; i++) {
            if (aIdx == mid) arr[i] = temp[bIdx++];
            else if (bIdx == en) arr[i] = temp[aIdx++];
            else if (temp[aIdx].age <= temp[bIdx].age) arr[i] = temp[aIdx++];
            else arr[i] = temp[bIdx++];
        }
    }
 
}
 
class Member {
    int age;
    String name;
    
    Member (int age, String name) {
        this.age = age;
        this.name = name;
    }
}

//내장 함수를 활용한 풀이
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.Arrays;
//        import java.util.StringTokenizer;
//
//public class Main {
//
//    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    private static StringTokenizer st;
//    private static StringBuilder sb = new StringBuilder();
//    private static int n;
//    private static Member[] arr;
//
//    public static void main(String[] args) throws IOException {
//        n = Integer.parseInt(br.readLine());
//        arr = new Member[n];
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            int age = Integer.parseInt(st.nextToken());
//            String name = st.nextToken();
//            arr[i] = new Member(age, name);
//        }
//
//        Arrays.sort(arr);
//
//        for (Member m : arr)
//            sb.append(m.age).append(" ").append(m.name).append("\n");
//
//        System.out.println(sb);
//    }
//
//}
//
//class Member implements Comparable<Member>{
//    int age;
//    String name;
//
//    Member (int age, String name) {
//        this.age = age;
//        this.name = name;
//    }
//
//    @Override
//    public int compareTo(Member o) {
//        return Integer.compare(this.age, o.age);
//    }
//}