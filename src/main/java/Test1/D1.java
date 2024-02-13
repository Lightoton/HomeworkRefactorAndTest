package Test1;

import java.util.List;

public class D1 {
    public double calculateAverageValueForGivenList(List<Double> listOfNumbers) {
        double sumOfAllValues = 0;
        for (double currentValue : listOfNumbers) {
            sumOfAllValues += currentValue;
        }
        return sumOfAllValues / listOfNumbers.size();
    }
    public double calculateAverageValueForGivenListNew(List<Double> listOfNumbers) {
        return listOfNumbers.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}


