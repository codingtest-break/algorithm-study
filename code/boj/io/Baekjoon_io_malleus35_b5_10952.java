import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int answer = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).reduce((x, y) -> x + y).getAsInt();
            if (answer != 0) {
                System.out.println(answer);
            }
        }
    }
}