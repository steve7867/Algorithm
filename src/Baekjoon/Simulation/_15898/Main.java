/**
 * 피아의 아틀리에 ~신비한 대회의 연금술사~
 * https://www.acmicpc.net/problem/15898
 *
 * 시간 복잡도는 O((10 * 9 * 8) * (4 * 4 * 4) * (4 * 4 * 4))이다.
 * 배열을 한방향으로 회전하는 것은 O(16)이다.
 * 이걸 여러번 써서 배열을 회전시키면 시간복잡도가 O(48)이 된다.따라서 각 방향에 맞게 한번에 회전시키는 방식으로 구현해야 한다.
 */
package Baekjoon.Simulation._15898;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static final int W = 0;
    static final int R = 1;
    static final int B = 2;
    static final int G = 3;
    static final int Y = 4;
    static int n;
    static int[][][] effects;
    static int[][][] elements;
    static Info[] infos;
    static boolean[] visited;
    static int ans = 0;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        effects = new int[n][4][4];
        elements = new int[n][4][4];
        infos = new Info[n];
        visited = new boolean[n];
 
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < 4; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < 4; y++) {
                    effects[i][x][y] = Integer.parseInt(st.nextToken());
                }
            }
 
            for (int x = 0; x < 4; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < 4; y++) {
                    switch (st.nextToken().charAt(0)) {
                        case 'R':
                            elements[i][x][y] = R;
                            break;
                        case 'B':
                            elements[i][x][y] = B;
                            break;
                        case 'G':
                            elements[i][x][y] = G;
                            break;
                        case 'Y':
                            elements[i][x][y] = Y;
                            break;
                    }
                }
            }
        }
 
        backtrack(0);
        System.out.println(ans);
    }
 
    private static void backtrack(int idx) {
        if (idx == 3) {
            int[][] quality = new int[5][5];
            int[][] color = new int[5][5];
 
            for (int i = 0; i < 3; i++) {
                Info info = infos[i];
                int[][] effect = effects[info.num];
                int[][] element = elements[info.num];
 
                insert(quality, color, effect, element, info.pos, info.dir);
            }
 
            int r = 0, b = 0, g = 0, y = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++)
                    switch (color[i][j]) {
                        case R:
                            r += quality[i][j];
                            break;
                        case B:
                            b += quality[i][j];
                            break;
                        case G:
                            g += quality[i][j];
                            break;
                        case Y:
                            y += quality[i][j];
                            break;
                    }
            }
 
            int sum = 7 * r + 5 * b + 3 * g + 2 * y;
 
            if (sum > ans)
                ans = sum;
 
            return;
        }
 
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
 
            visited[i] = true;
            for (int pos = 0; pos < 4; pos++) {
                for (int dir = 0; dir < 4; dir++) {
                    infos[idx] = new Info(i, pos, dir);
                    backtrack(idx + 1);
                }
            }
 
            visited[i] = false;
            infos[idx] = null;
        }
    }
 
    // 위치에 맞게 회전해서 삽입
    private static void insert(int[][] quality, int[][] color, int[][] effect, int[][] element, int pos, int dir) {
        int sX = pos / 2;
        int sY = pos % 2;
        switch (dir) {
            case 0:
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        int result = quality[sX + x][sY + y] + effect[x][y];
                        if (result < 0) result = 0;
                        else if (result > 9) result = 9;
                        quality[sX + x][sY + y] = result;
 
                        if (element[x][y] != W)
                            color[sX + x][sY + y] = element[x][y];
                    }
                }
                break;
            case 1:
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        int result = quality[sX + x][sY + y] + effect[y][3 - x];
                        if (result < 0) result = 0;
                        else if (result > 9) result = 9;
                        quality[sX + x][sY + y] = result;
 
                        if (element[y][3 - x] != W)
                            color[sX + x][sY + y] = element[y][3 - x];
                    }
                }
                break;
            case 2:
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        int result = quality[sX + x][sY + y] + effect[3 - x][3 - y];
                        if (result < 0) result = 0;
                        else if (result > 9) result = 9;
                        quality[sX + x][sY + y] = result;
 
                        if (element[3 - x][3 - y] != W)
                            color[sX + x][sY + y] = element[3 - x][3 - y];
                    }
                }
                break;
            case 3:
                for (int x = 0; x < 4; x++) {
                    for (int y = 0; y < 4; y++) {
                        int result = quality[sX + x][sY + y] + effect[3 - y][x];
                        if (result < 0) result = 0;
                        else if (result > 9) result = 9;
                        quality[sX + x][sY + y] = result;
 
                        if (element[3 - y][x] != W)
                            color[sX + x][sY + y] = element[3 - y][x];
                    }
                }
                break;
        }
    }
 
    static class Info {
        int num;
        int pos;
        int dir;
 
        public Info(int num, int pos, int rotate) {
            this.num = num;
            this.pos = pos;
            this.dir = rotate;
        }
    }
}
