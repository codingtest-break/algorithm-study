import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baekjoon_backtracking_s2_15664 {

    static StringBuilder result = new StringBuilder();
    static List<Integer> stack = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> numberList = new ArrayList<>();
    static List<Integer> distinctNumberList = new ArrayList<>(); 
    static Set<String> resultSet = new HashSet<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        /* numberList에 숫자 채우기 */
        for (String num : br.readLine().split(" "))
            numberList.add(Integer.parseInt(num));
        /* numberList 오름차순 정렬 (Selection Sort ASC) */
        for (int i = 0; i < numberList.size(); i++)
            for (int j = i + 1; j < numberList.size(); j++) {
                int numI = numberList.get(i);
                int numJ = numberList.get(j);
                if (numI > numJ) {
                    numberList.set(i, numJ);
                    numberList.set(j, numI);
                }
            }

        for (int num : numberList) {
            if (distinctNumberList.indexOf(num) == -1) {
                distinctNumberList.add(num);
            }
        }
        /* graph 그리기 */
        for (int fromIdx = 0; fromIdx < N; fromIdx++) {
            List<Integer> toIdxList = new ArrayList<>();
            graph.add(toIdxList);
            for (int toIdx = 0; toIdx < N; toIdx++) {
                if (fromIdx != toIdx)
                    toIdxList.add(toIdx);
            } // for
            //System.out.println(toIdxList);
        }

        // System.out.println("numberList : " + numberList);
        // System.out.println("distinctNumberList : " + distinctNumberList);
        // System.out.println("duplicatedNumberList : " + duplicatedNumberList);
        for (int startIdx = 0; startIdx < distinctNumberList.size(); startIdx++)
            dfs(numberList.indexOf(distinctNumberList.get(startIdx)));

        /* 마지막 개행 제거 */
        if (result.length() > 0)
            result.deleteCharAt(result.length() - 1);
        System.out.print(result);
    } // main
  
    public static void dfs(int fromIdx) {
        stack.add(fromIdx);
        //System.out.println(stack);
        int fromNum = numberList.get(fromIdx);
        for (int toIdx : graph.get(fromIdx)) {
            int toNum = numberList.get(toIdx);
            if ( stack.size() < M
              && stack.indexOf(toIdx) == -1  
              && fromNum <= toNum
               ) {
                dfs(toIdx);
            }
        }
        if (stack.size() == M) {
            StringBuilder line = new StringBuilder();
            for (int element : stack) {
                line.append(numberList.get(element) + " ");
            }
            line.deleteCharAt(line.length() - 1);
            if ( !resultSet.contains(line.toString())) {
                resultSet.add(line.toString());
                result.append(line.toString() + "\n");
            }
            
        }
        stack.remove(stack.size() - 1);
    }
}
