 /**
  * 염라대왕의 이름 정렬
  * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWqU0zh6rssDFARG
  *
 * String의 compareTo(String s) 메소드는 길이를 고려하지 않는다.
 * "z".compareTo("abc")는 25이다.
 */
 package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution_7701 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String[] temp = new String[20000];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int TC = stoi(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            int n = stoi(br.readLine());
            String[] arr = input(n);

            mergeSort(arr, 0, arr.length);

            sb.append('#')
                    .append(tc)
                    .append('\n');

            for (String s : arr)
                sb.append(s).append('\n');
        }

        System.out.println(sb);
    }

    private static void mergeSort(String[] arr, int st, int en) {
        if (st == en - 1)
            return;

        int mid = (st + en) / 2;
        mergeSort(arr, st, mid);
        mergeSort(arr, mid, en);

        merge(arr, st, en);
    }

    private static void merge(String[] arr, int st, int en) {
        System.arraycopy(arr, st, temp, st, en - st);

        int mid = (st + en) / 2;

        int aIdx = st;
        int bIdx = mid;
        for (int i = st; i < en; i++) {
            if (aIdx == mid)
                arr[i] = temp[bIdx++];
            else if (bIdx == en)
                arr[i] = temp[aIdx++];
            else if (compare(temp[aIdx], temp[bIdx]) <= 0)
                arr[i] = temp[aIdx++];
            else
                arr[i] = temp[bIdx++];
        }
    }

    private static int compare(String s1, String s2) {
        if (s1.length() == s2.length())
            return s1.compareTo(s2);

        return s1.length() - s2.length();
    }

    private static String[] input(int n) throws IOException {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(br.readLine());

        String[] arr = new String[set.size()];
        int i = 0;
        for (String s : set)
            arr[i++] = s;

        return arr;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}