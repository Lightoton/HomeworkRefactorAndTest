package Test1;

import java.util.List;

// Нарушение CODE SMELLS:
//  Я так понял, была проблема в названии метода, ну и вынес логику счета среднего значения в отдельный метод
//  ну и решил переписать расчёт average в стрим
public class DAta {
    public double standardDeviation (List<Double> numbers) {
        double average = getAverage(numbers);
        double variance = 0;
        for (double num : numbers) {
            variance += Math.pow(num - average, 2);
        }
         return Math.sqrt(variance / numbers.size());
    }
    private static double getAverage(List<Double> numbers){
//        double sum = 0;
//        for (double num : numbers) {
//            sum += num;
//        }
//        return sum / numbers.size();
        return numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}
