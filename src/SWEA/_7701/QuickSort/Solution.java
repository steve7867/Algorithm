package SWEA._7701.QuickSort; /**
 * 염라대왕의 이름 정렬
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWqU0zh6rssDFARG
 *
 * String의 compareTo(String s) 메소드는 길이를 고려하지 않는다.
 * "z".compareTo("abc")는 25이다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String[] temp = new String[20000];

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int TC = stoi(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            int n = stoi(br.readLine());
            String[] arr = input(n);

            quickSort(arr, 0, arr.length);

            sb.append('#')
                    .append(tc)
                    .append('\n');

            for (String s : arr)
                sb.append(s).append('\n');
        }

        System.out.println(sb);
    }

    private static void quickSort(String[] arr, int st, int en) {
        if (st >= en - 1)
            return;

        String pivot = arr[st];
        int l = st + 1;
        int r = en - 1;

        while (true) {
            while (l <= r && compare(arr[l], pivot) <= 0)
                l++;

            while (l <= r && compare(arr[r], pivot) > 0)
                r--;

            if (l > r)
                break;

            swap(arr, l, r);
        }

        swap(arr, st, r);

        quickSort(arr, st, r);
        quickSort(arr, r + 1, en);
    }

    private static void swap(String[] arr, int l, int r) {
        String temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
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