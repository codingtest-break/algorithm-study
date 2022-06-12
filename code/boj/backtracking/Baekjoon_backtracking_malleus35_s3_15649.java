import java.io.*;
import java.util.*;

class Main_15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nAndM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.print(new Solution_15649(nAndM[0], nAndM[1]).solution());
    }
}

class Solution_15649 {
    private int N;
    private int M;
    private int[] arr;
    private boolean[] visited;
    private StringBuilder sb;

    Solution_15649(int N, int M) {
        this.N = N;
        this.M = M;
        arr = new int[M];
        sb = new StringBuilder();
        visited = new boolean[N];
    }

    public String solution() {
        backTrack(0, 1);
        return sb.toString();
    }

    private void backTrack(int depth, int num) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[depth] = i + 1;
            backTrack(depth + 1, i);
            visited[i] = false;
        }
    }
}