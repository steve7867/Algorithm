/**
 * 수업
 * https://www.acmicpc.net/problem/19700
 * 문제 해설: https://entrydeveloper.tistory.com/487
 */
package Baekjoon.BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_19700 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        List<Student> studList = new ArrayList<>();
        TreeMap<Integer, Integer> teamMap = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int rank = Integer.parseInt(st.nextToken());

            Student student = new Student(height, rank);

            studList.add(student);
        }

        Collections.sort(studList);

        for (Student student : studList) {
            Integer a = teamMap.lowerKey(student.rank);
            if (a == null) {
                teamMap.put(1, teamMap.getOrDefault(1, 0) + 1);
                continue;
            }

            int num = teamMap.get(a);
            if (num == 1)
                teamMap.remove(a);
            else
                teamMap.put(a, num - 1);

            teamMap.put(a + 1, teamMap.getOrDefault(a + 1, 0) + 1);
        }

        int answer = 0;
        for (int value : teamMap.values())
            answer += value;

        System.out.println(answer);
    }
}

class Student implements Comparable<Student> {
    int height;
    int rank;

    public Student(int height, int rank) {
        this.height = height;
        this.rank = rank;
    }

    @Override
    public int compareTo(Student o) {
        if (this.height == o.height)
            return -Integer.compare(this.rank, o.rank);
        return -Integer.compare(this.height, o.height);
    }
}