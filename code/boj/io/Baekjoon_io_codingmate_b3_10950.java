import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_io_b3_10950 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int row = 0; row < T; row++) {
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            int sum = A + B;
            result.append(sum + "\n");
        }
        result.deleteCharAt(result.length() - 1);
        System.out.print(result);
    }
}