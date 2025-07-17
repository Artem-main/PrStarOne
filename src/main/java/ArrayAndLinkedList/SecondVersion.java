package ArrayAndLinkedList;

import java.util.ArrayList;
import java.util.List;

public class SecondVersion {
        public static void main(String[] args) {
            List<Integer> numbers = List.of(1, 7, 9, 4, 3);
            int windowSize = 4;

            try {
                List<Double> averages = calculateAverages(numbers, windowSize);
                System.out.println(averages);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        public static List<Double> calculateAverages(List<Integer> nums, int k) {
            if (nums.size() < k || k <= 0) {
                throw new IllegalArgumentException("Некорректные параметры");
            }

            List<Double> result = new ArrayList<>();

            for (int i = 0; i <= nums.size() - k; i++) {
                int sum = 0;
                for (int j = i; j < i + k; j++) {
                    sum += nums.get(j);
                }
                result.add((double) sum / k);
            }

            return result;
        }
}
