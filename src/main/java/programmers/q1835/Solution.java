package programmers.q1835;

/** https://school.programmers.co.kr/learn/courses/30/lessons/1835 */
/** 단체사진 찍기 */
public class Solution {

    // 사진 찍는 멤버
    private final char[] members = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    // 정답 카운트
    private int count;

    public int solution(int n, String[] data) {
        permutations(data, "", new boolean[members.length], 0);
        return count;
    }

    // 순열 만들기
    private void permutations(String[] data, String permutation, boolean[] visited, int depth) {
        if (depth == members.length) {
            count += isValid(data, permutation) ? 1 : 0;
            return;
        }
        for (int i=0; i<members.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation += members[i];
                permutations(data, permutation, visited, depth + 1);
                permutation = permutation.substring(0, permutation.length() - 1);
                visited[i] = false;
            }
        }
    }

    // 조건을 만족하는 순서인지 확인
    private boolean isValid(String[] data, String permutation) {
        for (String condition : data) {
            char c1 = condition.charAt(0);
            char c2 = condition.charAt(2);
            char comp = condition.charAt(3);
            int num = condition.charAt(4) - '0';
            int diff = Math.abs(permutation.indexOf(c1) - permutation.indexOf(c2));

            if ((comp == '>' && diff - 1 <= num) || (comp == '<' && diff - 1 >= num) || (comp == '=' && diff - 1 != num))
                return false;
        }
        return true;
    }
}
