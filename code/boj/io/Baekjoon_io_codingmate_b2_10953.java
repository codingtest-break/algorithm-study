import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_io_b2_10953 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for ( int row = 0; row < T; row++ ){
            String line = br.readLine();
            String[] AB = line.split(",");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            int sum = A + B;
            System.out.println(sum);
        }
    }
}