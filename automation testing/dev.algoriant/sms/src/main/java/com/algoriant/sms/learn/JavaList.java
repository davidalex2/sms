package com.algoriant.sms.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 2, 4, 3, 2, 5);
        list.stream().collect(Collectors.toList()).forEach(System.out::println);
        // list.stream()
        for (Integer list1:list) {
            System.out.println(list1);

        }
    }
}
