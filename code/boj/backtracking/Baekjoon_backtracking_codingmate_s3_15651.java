import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon_backtracking_s3_15651 {

    static StringBuilder result = new StringBuilder();
    static List<Integer> stack = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> numberList = new ArrayList<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        /* numberList에 숫자 채우기 */
        for (int num = 1; num <= N; num++)
            numberList.add(num);

        /* graphList 그리기 */
        for (int fromIdx = 0; fromIdx < N; fromIdx++) {
            List<Integer> toIdxList = new ArrayList<>();
            graph.add(toIdxList);
            for (int toIdx = 0; toIdx < N; toIdx++)
                //if (fromIdx != toIdx)
                    toIdxList.add(toIdx);
        }

        for (int startIdx = 0; startIdx < N; startIdx++)
            dfs(startIdx);

        /* 마지막 개행 제거 */
        result.deleteCharAt(result.length() - 1);
        System.out.print(result);
    } // main

    public static void dfs(int fromIdx) {
        stack.add(fromIdx);

        for (int toIdx : graph.get(fromIdx))
            if (stack.size() < M /*&& stack.indexOf(toIdx) == -1 && numberList.get(fromIdx) < numberList.get(toIdx) */)
                dfs(toIdx);

        if (stack.size() == M) {
            for (int element : stack) {
                result.append(numberList.get(element) + " ");
            }
            /* 마지막 공백 제거 */
            result.deleteCharAt(result.length() - 1);
            result.append("\n");
        }
        stack.remove(stack.size() - 1);
    }
}
