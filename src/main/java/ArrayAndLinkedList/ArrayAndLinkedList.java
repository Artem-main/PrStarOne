package ArrayAndLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayAndLinkedList {
    public static void main(String[] args) {
        ArrayList <Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 5, 6, 4, 3));
        int k = 2;
        double summ = 0;

        averageNumber(arrayList, k, summ);
    }

    public static void averageNumber(ArrayList<Integer> arrayList, int k, double summFirst) {
        if (k < 0 || k > arrayList.size()) {
            System.out.println("Некорректное число 'k'");
        }

        LinkedList<Integer> averageList = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            averageList.add(arrayList.get(i));
        }
        System.out.println("Первые k элемента " + averageList);
        for (Integer ch : averageList) {
            summFirst += (Double.parseDouble(String.valueOf(ch)))/k;
        }
        System.out.println(summFirst);
        summFirst = 0;

        for (int i = k; i < arrayList.size(); i++) {
            averageList.add(arrayList.get(i));
            averageList.remove();
            System.out.println("Следующие k элементов " + averageList);

            for (Integer ch : averageList) {
                summFirst += (Double.parseDouble(String.valueOf(ch)))/k;
            }
            System.out.println(summFirst);
            summFirst = 0;
        }


        List<Double> result = new ArrayList<>();

        for (int i = 0; i <= arrayList.size() - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arrayList.get(j);
            }
            result.add((double) sum / k);
        }
        System.out.println(result);
    }
}
