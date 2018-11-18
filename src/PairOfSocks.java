import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PairOfSocks {


    public static void main(String[] args) {
        int[] array = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        Map<Integer, Long> collected = Arrays.stream(array).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collected);

        long count = collected.entrySet().stream()
                .filter((entry) -> entry.getValue() >= 2)
                .mapToLong(entry -> entry.getValue() / 2)
                .sum();

        System.out.println("You have " + Math.toIntExact(count) + " pair/s");
    }

}
