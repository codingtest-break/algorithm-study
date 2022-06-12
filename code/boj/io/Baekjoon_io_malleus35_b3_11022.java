package io;

import java.io.*;
import java.util.*;

class Main_11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            String[] arr = br.readLine().split(" ");
            System.out.println(
                    "Case #" + i + ": " + arr[0] + " + " + arr[1] + " = "
                            + Arrays.stream(arr).mapToInt(e -> Integer.parseInt(e))
                                    .reduce((x, y) -> x + y).getAsInt());
        }

    }
}