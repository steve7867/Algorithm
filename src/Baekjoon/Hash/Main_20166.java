/**
 * 문자열 지옥에 빠진 호석
 * https://www.acmicpc.net/problem/20166
 */
package Baekjoon.Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main_20166 {
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Character, List<Pair>> map = new HashMap<>();
    static Map<String, Integer> stringDP = new HashMap<>();
    static Map<String, Integer>[][] arrayDP = new Map[10][10];
    static int n;
    static int m;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
 
    static {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arrayDP[i][j] = new HashMap<>();
            }
        }
    }
 
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = input.charAt(j);
                if (map.containsKey(c))
                    map.get(c).add(new Pair(i, j));
                else {
                    List<Pair> newList = new ArrayList<>();
                    newList.add(new Pair(i, j));
                    map.put(c, newList);
                }
            }
        }
 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            String input = br.readLine();
            sb.append(backtrack(input, 0, null))
                    .append('\n');
        }
 
        System.out.println(sb);
    }
 
    private static int backtrack(String s, int i, Pair pre) {
        if (i == s.length())
            return 1;
 
        String key;
        if (pre == null) {
            key = s;
            if (stringDP.containsKey(key))
                return stringDP.get(key);
        } else {
            key = s.substring(i);
            if (arrayDP[pre.x][pre.y].containsKey(key))
                return arrayDP[pre.x][pre.y].get(key);
        }
 
        List<Pair> list = map.get(s.charAt(i));
 
        int ret = 0;
        if (list != null) {
            for (Pair cur : list) {
                if (!isAdjacent(pre, cur))
                    continue;
 
                ret += backtrack(s, i + 1, cur);
            }
        }
 
        if (pre == null)
            stringDP.put(key, ret);
        else
            arrayDP[pre.x][pre.y].put(key, ret);
 
        return ret;
    }
 
    private static boolean isAdjacent(Pair pre, Pair cur) {
        if (pre == null)
            return true;
 
        int preX = pre.x;
        int preY = pre.y;
        int curX = cur.x;
        int curY = cur.y;
 
        for (int i = 0; i < 8; i++) {
            int nx = preX + dx[i];
            int ny = preY + dy[i];
 
            if (nx == -1)
                nx = n - 1;
            if (nx == n)
                nx = 0;
 
            if (ny == -1)
                ny = m - 1;
            if (ny == m)
                ny = 0;
 
            if (nx == curX && ny == curY)
                return true;
        }
        return false;
    }
}
 
class Pair {
    int x;
    int y;
 
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
