package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> result = new ArrayList<>();
        int minValue = Math.min(left, right);
        int maxValue = Math.max(left, right);

        for(int itr = minValue; itr <= maxValue; itr++){
            result.add(itr);
        }

        if(left > right){
            result.sort(Comparator.reverseOrder());
        }

        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> result = new ArrayList<>();
        int minValue = Math.min(left, right);
        int maxValue = Math.max(left, right);

        for(int itr = minValue; itr <= maxValue; itr++){
            if (itr % 2 == 0) {
                result.add(itr);
            }
        }

        if(left > right){
            result.sort(Comparator.reverseOrder());
        }

        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array)
                .filter(element -> element % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> list1 = Arrays.stream(firstArray)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> list2 = Arrays.stream(secondArray)
                .boxed()
                .collect(Collectors.toList());

        return list1.stream()
                .filter(element -> list2.contains(element))
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> list1 = Arrays.stream(firstArray)
                .mapToInt(Integer::intValue)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> list2 = Arrays.stream(secondArray)
                .mapToInt(Integer::intValue)
                .boxed()
                .collect(Collectors.toList());

        list1.addAll(list2.stream()
                .filter(element -> !list1
                        .contains(element))
                .collect(Collectors.toList()));

        return list1;
    }
}
