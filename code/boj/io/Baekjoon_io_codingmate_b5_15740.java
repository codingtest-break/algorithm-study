import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Baekjoon_io_b5_15740 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.print(Arrays.stream(br.readLine().split(" ")).map( num -> new BigInteger(num) ).reduce((x, y) -> x.add(y)).get());
    }   
}