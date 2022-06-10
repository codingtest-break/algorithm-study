package code.boj.backtracking;

import java.io.*;
import java.util.*;

class Main_15651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NAndM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.print(new Solution_15651(NAndM[0], NAndM[1]).solution());
    }
}

class Solution_15651 {
    private int N;
    private int M;
    private int[] arr;
    private StringBuilder sb;

    Solution_15651(int N, int M) {
        this.N = N;
        this.M = M;
        arr = new int[M];
        sb = new StringBuilder();
    }

    public String solution() {
        backTrack(0);
        return sb.toString();
    }

    private void backTrack(int depth) {
        if (depth == M) {
            Arrays.stream(arr).forEach(e -> sb.append(e).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i + 1;
            backTrack(depth + 1);
        }
    }
}
