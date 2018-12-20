package work.usepdf.repository;


import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.stream.Stream;

@Repository
public class ArrayNumberLearnedUnits {

    public Integer[] getLearnedUnits() {
        Integer[] first = Stream.iterate(1, x -> x + 1).limit(48).toArray(Integer[]::new);
        Integer[] second = new Integer[]{82, 83, 84, 85, 86, 87, 88, 89, 90, 91};
        return Stream.concat(Arrays.stream(first), Arrays.stream(second)).toArray(Integer[]::new);
    }
}
