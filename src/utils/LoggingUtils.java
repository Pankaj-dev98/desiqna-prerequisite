package utils;

import java.lang.reflect.Array;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoggingUtils {
    public static void print(Object... args) {
        for (Object o : args) {

            if (o != null && o.getClass().isArray()) {
                int length = Array.getLength(o);
                String result = IntStream.range(0, length)
                    .mapToObj(i -> String.valueOf(Array.get(o, i)))
                    .collect(Collectors.joining(", ", "[", "]"));
                System.out.println(result);
                continue;
            }
            System.out.println(o);
        }
        System.out.println("----");
    }
}