/**
 * 친구 네트워크
 * https://www.acmicpc.net/problem/4195
 */
package Baekjoon.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main_4195 {
    private static int[] p;
    private static int[] size;
    private static Map<String, Integer> nameToNum;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
 
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            p = new int[2 * n];
            for (int i = 0; i <= 2 * n - 1; i++)
                p[i] = i;
 
            size = new int[2 * n];
            Arrays.fill(size, 1);
 
            nameToNum = new HashMap<>();
            int serialID = 0;
 
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String aName = st.nextToken();
                String bName = st.nextToken();
 
                serialID = registerName(aName, bName, serialID);
 
                int a = nameToNum.get(aName);
                int b = nameToNum.get(bName);
 
                sb.append(union(a, b)).append('\n');
            }
        }
 
        System.out.println(sb);
    }
 
    private static int union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
 
        if (aRoot == bRoot)
            return size[aRoot];
 
        int c = Integer.compare(size[aRoot], size[bRoot]);
        int ret;
        if (c >= 0) {
            p[bRoot] = aRoot;
            size[aRoot] += size[bRoot];
            ret = size[aRoot];
        } else {
            p[aRoot] = bRoot;
            size[bRoot] += size[aRoot];
            ret = size[bRoot];
        }
 
        return ret;
    }
 
    private static int find(int i) {
        if (i != p[i])
            p[i] = find(p[i]);
 
        return p[i];
    }
 
    private static int registerName(String aName, String bName, int serialID) {
        if (!nameToNum.containsKey(aName))
            nameToNum.put(aName, serialID++);
 
        if (!nameToNum.containsKey(bName))
            nameToNum.put(bName, serialID++);
 
        return serialID;
    }
}
