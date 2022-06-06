import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_io_b3_10951 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String line = new String();
        while ( (line = br.readLine()) != null && !line.equals("")) {

            String[] AB = line.split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            int sum = A + B;
            System.out.println(sum);
        }
    }
}