import java.io.*;
import java.util.*;

class Main_15652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NAndM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.print(new Solution_15652(NAndM[0], NAndM[1]).solution());
    }
}

class Solution_15652 {
    private int N;
    private int M;
    private int[] arr;
    private boolean[] visited;
    private StringBuilder sb;

    Solution_15652(int N, int M) {
        this.N = N;
        this.M = M;
        arr = new int[M];
        visited = new boolean[N];
        sb = new StringBuilder();
    }

    public String solution() {
        backTrack(0, 0);
        return sb.toString();
    }

    private void backTrack(int depth, int num) {
        if (depth == M) {
            Arrays.stream(arr).forEach(e -> sb.append(e).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = num; i < N; i++) {
            arr[depth] = i + 1;
            backTrack(depth + 1, i);
        }
    }
}