import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out
                .println(Arrays.stream(br.readLine().split(" ")).map(BigInteger::new).reduce((x, y) -> x.add(y)).get());
    }
}