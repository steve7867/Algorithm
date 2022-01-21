/**
 * ThreeLetters
 * https://app.codility.com/programmers/trainings/5/three_letters/
 */
package Codility;

class ThreeLetters {

    public String solution(int A, int B) {
        StringBuilder ret = new StringBuilder();
        boolean aIsMore = A > B;

        while (A != B) {
            if (aIsMore) {
                if (A >= 2) {
                    ret.append("aa");
                    A -= 2;
                } else if (A == 1) {
                    ret.append('a');
                    A--;
                }

                if (B > 0) {
                    ret.append('b');
                    B--;
                }
            } else {
                if (B >= 2) {
                    ret.append("bb");
                    B -= 2;
                } else if (B == 1) {
                    ret.append('b');
                    B--;
                }

                if (A > 0) {
                    ret.append('a');
                    A--;
                }
            }
        }

        ret.append(repeatAB(A, aIsMore));
        return ret.toString();
    }

    private String repeatAB(int n, boolean aFirst) {
        StringBuilder ret = new StringBuilder();

        String chunk = aFirst ? "ab" : "ba";

        for (int i = 0; i < n; i++) {
            ret.append(chunk);
        }

        return ret.toString();
    }

}
