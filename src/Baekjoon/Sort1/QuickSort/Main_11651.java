/**
 * 좌표 정렬하기 2
 * https://www.acmicpc.net/problem/11651
 */
package Baekjoon.Sort1.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_11651 {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static Point[] arr;
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new Point[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
        }
        
        quickSort(0, n);
        
        for (Point p : arr)
            sb.append(p.x).append(" ").append(p.y).append("\n");
        
        System.out.println(sb);
    }
 
    private static void quickSort(int st, int en) {
        if (st >= en - 1) return;
        
        int pivot = st;
        int l = st + 1;
        int r = en - 1;
        while (true) {
            while (l <= r && arr[l].compareTo(arr[pivot]) <= 0) l++;
            while (arr[r].compareTo(arr[pivot]) == 1) r--;
            if (l > r) break;
            swap(arr, l, r);
        }
        
        swap(arr, pivot, r);
        
        quickSort(st, r);
        quickSort(r + 1, en);
    }
 
    private static void swap(Point[] arr, int a, int b) {
        if (a == b) return;
        
        Point temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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
