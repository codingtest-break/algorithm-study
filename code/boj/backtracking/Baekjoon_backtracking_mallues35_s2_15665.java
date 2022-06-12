import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main_15665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NAndM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(new Solution_15665(NAndM[0], NAndM[1], numbers).solution());
    }
}

class Solution_15665 {
    private final int N;
    private final int M;
    private final int[] numbers;
    private final int[] arr;
    private final StringBuilder sb = new StringBuilder();
    private final Set<String> set = new HashSet<>();

    public Solution_15665(int n, int m, int[] numbers) {
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
            StringBuilder lineBuilder = new StringBuilder();
            Arrays.stream(arr).forEach(e -> lineBuilder.append(e).append(" "));

            if(set.contains(lineBuilder.toString())) {
                return;
            }
            set.add(lineBuilder.toString());
            sb.append(lineBuilder).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = numbers[i];
            backTrack(depth + 1);
        }
    }
}