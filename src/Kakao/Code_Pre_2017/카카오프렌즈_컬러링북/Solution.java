/**
 * 카카오프렌즈 컬러링북
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 */
package Kakao.Code_Pre_2017.카카오프렌즈_컬러링북;

class Solution {
    static boolean[][] visited;
 
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
 
        visited = new boolean[m][n];
 
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (!visited[i][j]) {
                    int size = check(i, j, picture);
                    if (size > 0) {
                        numberOfArea++;
                        if (size > maxSizeOfOneArea)
                            maxSizeOfOneArea = size;
                    }
                }
            }
        }
 
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
 
    private static int check(int m, int n, int[][] picture) {
        visited[m][n] = true;
        if (picture[m][n] == 0) return 0;
 
        int size = 1;
 
        if (m + 1 < picture.length && picture[m][n] == picture[m + 1][n] && !visited[m + 1][n]) {
            visited[m + 1][n] = true;
            size += check(m + 1, n, picture);
        }
 
        if (m - 1 >= 0 && picture[m][n] == picture[m - 1][n] && !visited[m - 1][n]) {
            visited[m - 1][n] = true;
            size += check(m - 1, n, picture);
        }
 
        if (n + 1 < picture[m].length && picture[m][n] == picture[m][n + 1] && !visited[m][n + 1]) {
            visited[m][n + 1] = true;
            size += check(m, n + 1, picture);
        }
 
        if (n - 1 >= 0 && picture[m][n] == picture[m][n - 1] && !visited[m][n - 1]) {
            visited[m][n - 1] = true;
            size += check(m, n - 1, picture);
        }
 
        return size;
    }
}
