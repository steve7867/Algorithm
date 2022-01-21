/**
 * 좌표 압축
 * https://www.acmicpc.net/problem/18870
 */
package Baekjoon.Binary_Search;

import java.io.*;
import java.util.*;
 
public class Main_18870 {
    private static int n;
    private static int[] input, sortedArr;
    private static List<Integer> list = new ArrayList<>();
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
 
        input = new int[n];
        sortedArr = new int[n];
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            input[i] = Integer.parseInt(st.nextToken());
 
        System.arraycopy(input, 0, sortedArr, 0, n);
        Arrays.sort(sortedArr);
 
        list.add(sortedArr[0]);
        for (int i = 1; i < n; i++) {
            if (sortedArr[i] != sortedArr[i - 1])
                list.add(sortedArr[i]);
        }
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(binarySearch(input[i])).append(' ');
 
        System.out.println(sb);
    }
 
    private static int binarySearch(int target) {
        int st = 0, en = list.size() - 1;
 
        while (st <= en) {
            int mid = (st + en) / 2;
 
            if (list.get(mid) > target)
                en = mid - 1;
            else if (list.get(mid) < target)
                st = mid + 1;
            else
                return mid;
        }
 
        return -1;
    }
}
