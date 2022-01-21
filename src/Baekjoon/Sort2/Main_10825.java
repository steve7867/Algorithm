/**
 * 국영수
 * https://www.acmicpc.net/problem/10825
 */
package Baekjoon.Sort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main_10825 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static Student[] arr;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new Student[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            arr[i] = new Student(name, kor, eng, math);
        }
        
        Arrays.sort(arr);
        
        for (Student s : arr)
            sb.append(s.name).append("\n");
        
        System.out.println(sb);
    }
}
 
class Student implements Comparable<Student> {
    String name;
    int kor;
    int eng;
    int math;
    
    Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    
    @Override
    public int compareTo(Student o) {
        if (this.kor == o.kor) {
            if (this.eng == o.eng) {
                if (this.math == o.math) {
                    return this.name.compareTo(o.name);
                }
                return o.math - this.math;
            }
            return this.eng - o.eng;
        }
        return o.kor - this.kor;
    }
}