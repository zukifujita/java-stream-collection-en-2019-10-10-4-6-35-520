package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> filterEven() {
        return this.array.stream()
                .filter(element -> element % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return this.array.stream()
                .filter(element -> element % 3 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> list1 = firstList.stream()
                .mapToInt(Integer::intValue)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> list2 = secondList.stream()
                .mapToInt(Integer::intValue)
                .boxed()
                .collect(Collectors.toList());

        return list1.stream()
                .filter(element -> list2.contains(element))
                .collect(Collectors.toList());
    }

    public List<Integer> getDifferentElements() {
        return this.array.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}