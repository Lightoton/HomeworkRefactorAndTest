package Test1;

import java.util.Arrays;
import java.util.List;


public class MathUtils {
    public int calculateSum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
    
    public int calculateSum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
    //Переделал в стримы
}
