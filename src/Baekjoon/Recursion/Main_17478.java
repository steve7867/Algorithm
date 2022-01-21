/**
 * 재귀함수가 뭔가요?
 * https://www.acmicpc.net/problem/17478
 */
package Baekjoon.Recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Main_17478 {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        bw.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        func("", N);
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static void func(String line, int N) throws IOException {
        bw.append(line + "\"재귀함수가 뭔가요?\"\n");
        if (N > 0) {
            bw.append(line + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            bw.append(line + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            bw.append(line + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            func(line + "____", N - 1);
        } else if (N == 0) {
            bw.append(line +"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        }
        bw.append(line + "라고 답변하였지.\n");
    }
}
