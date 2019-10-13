package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int result = 0;
        int minValue = Math.min(leftBorder, rightBorder);
        int maxValue = Math.max(leftBorder, rightBorder);
        for(int itr = minValue; itr <= maxValue; itr++){
            if(itr % 2 == 0) {
                result += itr;
            }
        }
        return result;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int result = 0;
        int minValue = Math.min(leftBorder, rightBorder);
        int maxValue = Math.max(leftBorder, rightBorder);
        for(int itr = minValue; itr <= maxValue; itr++){
            if(itr % 2 != 0) {
                result += itr;
            }
        }
        return result;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .reduce(0, (a, b) -> a + b) * 3 + 2;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(element -> element % 2 != 0 ? 2 + (element * 3) : element)
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(element -> element % 2 != 0)
                .reduce(0,(a, b)-> a + b) * 3 + 5;
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(element -> element % 2 == 0)
                .reduce((a, b) -> a + b).get() / 2;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(element -> element % 2 == 0)
                .reduce((a, b) -> a + b).get() / 2;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.indexOf(specialElment) > -1 ?
                (specialElment % 2 == 0 ? true : false) : false;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(element -> element % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenNumbers = arrayList.stream()
                .filter(element -> element % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> oddNumbers = arrayList.stream()
                .filter(element -> element % 2 != 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        result.addAll(evenNumbers);
        result.addAll(oddNumbers);
        return result;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> lists = new ArrayList<>();

        for (int itr = 0; itr < arrayList.size(); itr++) {
            if(itr + 1 < arrayList.size() && itr != arrayList.size() - 1){
                lists.add((arrayList.get(itr) + arrayList.get(itr + 1))  * 3);
            }
        }

        return lists;
    }
}
