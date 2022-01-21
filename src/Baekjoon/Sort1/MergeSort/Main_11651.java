/**
 * 좌표 정렬하기 2
 * https://www.acmicpc.net/problem/11651
 */
package Baekjoon.Sort1.MergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_11651 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static Point[] arr, temp;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new Point[n];
        temp = new Point[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
        }
        
        mergeSort(0, n);
        
        for (Point p : arr)
            sb.append(p.x).append(" ").append(p.y).append("\n");
        
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
            else if (temp[aIdx].compareTo(temp[bIdx]) <= 0) arr[i] = temp[aIdx++];
            else arr[i] = temp[bIdx++];
        }
    }
}
 
class Point implements Comparable<Point>{
    int x;
    int y;
    
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    @Override
    public int compareTo(Point o) {
        if (this.y == o.y) return Integer.compare(this.x, o.x);
        return Integer.compare(this.y, o.y);
    }
}
