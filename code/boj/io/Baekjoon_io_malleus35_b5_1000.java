import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(
                Arrays.stream(br.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).reduce((x, y) -> x + y)
                        .getAsInt());
    }
}