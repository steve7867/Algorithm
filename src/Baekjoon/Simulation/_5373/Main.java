/**
 * 큐빙
 * https://www.acmicpc.net/problem/5373
 */
package Baekjoon.Simulation._5373;

import java.io.*;
import java.util.*;
 
public class Main {
 
    private static final Map<Character, Integer> planeMap = new HashMap<>();
    private static final char[][][] cube = new char[6][3][3];
    private static final char[] colors = {'w', 'y', 'r', 'o', 'g', 'b'};
 
    static {
        planeMap.put('U', 0); //위
        planeMap.put('D', 1); //아랫
        planeMap.put('F', 2); //앞
        planeMap.put('B', 3); //뒤
        planeMap.put('L', 4); //왼쪽
        planeMap.put('R', 5); //오른쪽
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            for (int p = 0; p < 6; p++) {
                for (int i = 0; i < 3; i++) {
                    Arrays.fill(cube[p][i], colors[p]);
                }
            }
 
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String order = st.nextToken();
                int plane = planeMap.get(order.charAt(0));
                boolean isClockWise = order.charAt(1) == '+';
 
                rotatePlane(plane, isClockWise);
                rotateEdge(plane, isClockWise);
            }
 
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(cube[0][i][j]);
                }
                sb.append('\n');
            }
        }
 
        System.out.println(sb);
    }
 
    private static void rotatePlane(int plane, boolean isClockWise) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++)
            System.arraycopy(cube[plane][i], 0, temp[i], 0, 3);
 
        if (isClockWise) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cube[plane][j][2 - i] = temp[i][j];
                }
            }
 
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cube[plane][2 - j][i] = temp[i][j];
                }
            }
        }
    }
 
    private static void rotateEdge(int plane, boolean isClockWise) {
        int[][] blocks = new int[4][3];
        if (plane == 0)
            blocks = new int[][] { {3,0,2}, {3,0,1}, {3,0,0},
                    {5,0,2}, {5,0,1}, {5,0,0},
                    {2,0,2}, {2,0,1}, {2,0,0},
                    {4,0,2}, {4,0,1}, {4,0,0} };
        if (plane == 1)
            blocks = new int[][] { {2,2,0}, {2,2,1}, {2,2,2},
                    {5,2,0}, {5,2,1}, {5,2,2},
                    {3,2,0}, {3,2,1}, {3,2,2},
                    {4,2,0}, {4,2,1}, {4,2,2} };
        if (plane == 2)
            blocks = new int[][] {{0,2,0}, {0,2,1}, {0,2,2},
                    {5,0,0}, {5,1,0}, {5,2,0},
                    {1,0,2}, {1,0,1}, {1,0,0},
                    {4,2,2}, {4,1,2}, {4,0,2}};
        if (plane == 3)
            blocks = new int[][]{{0,0,2}, {0,0,1}, {0,0,0},
                    {4,0,0}, {4,1,0}, {4,2,0},
                    {1,2,0}, {1,2,1}, {1,2,2},
                    {5,2,2}, {5,1,2}, {5,0,2}};
        if (plane == 4)
            blocks = new int[][]{{0,0,0}, {0,1,0}, {0,2,0},
                    {2,0,0}, {2,1,0}, {2,2,0},
                    {1,0,0}, {1,1,0}, {1,2,0},
                    {3,2,2}, {3,1,2}, {3,0,2}};
        if (plane == 5)
            blocks = new int[][]{{0,2,2}, {0,1,2}, {0,0,2},
                    {3,0,0}, {3,1,0}, {3,2,0},
                    {1,2,2}, {1,1,2}, {1,0,2},
                    {2,2,2}, {2,1,2}, {2,0,2}};
 
        Deque<Character> dq = new ArrayDeque<>();
        for (int[] block : blocks) {
            int p = block[0];
            int i = block[1];
            int j = block[2];
 
            dq.offerLast(cube[p][i][j]);
        }
 
        if (isClockWise) {
            for (int i = 0; i < 3; i++)
                dq.offerFirst(dq.pollLast());
        } else {
            for (int i = 0; i < 3; i++)
                dq.offerLast(dq.pollFirst());
        }
 
        for (int[] block : blocks) {
            int p = block[0];
            int i = block[1];
            int j = block[2];
 
            cube[p][i][j] = dq.pollFirst();
        }
    }
}