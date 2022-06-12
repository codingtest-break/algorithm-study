import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main_15656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NAndM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(new Solution_15656(NAndM[0], NAndM[1], numbers).solution());
    }
}

class Solution_15656 {
    private final int N;
    private final int M;
    private final int[] numbers;
    private final int[] arr;

    private final StringBuilder sb = new StringBuilder();
    public Solution_15656(int n, int m, int[] numbers) {
        N = n;
        M = m;
        this.numbers = numbers;
        arr = new int[M];
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
            arr[depth] = numbers[i];
            backTrack(depth + 1);
        }
    }
}