/**
 * 이차원 배열과 연산
 * https://www.acmicpc.net/problem/17140
 */
package Baekjoon.Simulation._17140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    private static int[][] arr = new int[100][100];
    private static int x = 3, y = 3;
    private static int r, c, k;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
 
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        boolean isPreviousRow = false;
        int sec = 0;
        while (arr[r][c] != k) {
            if (sec == 100) {
                System.out.println(-1);
                return;
            }
 
            if (isPreviousRow) {
                if (y > x) {
                    colCalc();
                    isPreviousRow = false;
                } else {
                    rowCalc();
                    isPreviousRow = true;
                }
            } else {
                if (x >= y) {
                    rowCalc();
                    isPreviousRow = true;
                } else {
                    colCalc();
                    isPreviousRow = false;
                }
            }
 
            sec++;
        }
 
        System.out.println(sec);
    }
 
    private static void rowCalc() {
        y = 0;
        for (int i = 0; i < 100; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < 100; j++) {
                int num = arr[i][j];
                if (num == 0)
                    continue;
 
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
 
            List<Integer> list = sort(map, true);
 
            int j = 0;
            for (int n : list)
                arr[i][j++] = n;
        }
    }
 
    private static void colCalc() {
        x = 0;
        for (int j = 0; j < 100; j++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < 100; i++) {
                int num = arr[i][j];
                if (num == 0)
                    continue;
 
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
 
            List<Integer> list = sort(map, false);
 
            int i = 0;
            for (int n : list)
                arr[i++][j] = n;
        }
    }
 
    private static List<Integer> sort(Map<Integer, Integer> map, boolean isRowCalc) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                int aOccur = a.getValue();
                int bOccur = b.getValue();
                if (aOccur == bOccur)
                    return Integer.compare(a.getKey(), b.getKey());
 
                return Integer.compare(aOccur, bOccur);
            }
        });
 
        List<Integer> temp = new ArrayList<>();
 
        for (Map.Entry<Integer, Integer> entry : list) {
            temp.add(entry.getKey());
            temp.add(entry.getValue());
        }
 
        if (isRowCalc) {
            if (temp.size() > y)
                y = temp.size();
        } else {
            if (temp.size() > x)
                x = temp.size();
        }
 
        while (temp.size() > 100)
            temp.remove(temp.size() - 1);
 
        while (temp.size() < 100)
            temp.add(0);
 
        return temp;
    }
}
