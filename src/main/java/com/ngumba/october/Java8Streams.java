package com.ngumba.october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java8Streams {

    public static void main(String[] args) {
        List<String> countriesList = new ArrayList<>();

        countriesList.add("Kenya");
        countriesList.add("Uganda");
        countriesList.add("Tanzania");
        countriesList.add("Rwanda");
        countriesList.add("Burundi");
        countriesList.add("South Sudan");
        countriesList.add("Ethiopia");
        countriesList.add("Somalia");
        countriesList.add("Somalia");


        // System.out.println("The size of the list is: " + countriesList.size());

        //countriesList.forEach(System.out::println);

       /* List<String> countriesUppercase = countriesList.stream().map(String::toUpperCase).toList();
        countriesUppercase.forEach(System.out::println);
        countriesList.stream().filter(country -> country.startsWith("K")).forEach(System.out::println);

        countriesList.stream().filter(country -> country.startsWith("K")).map(String::toUpperCase).forEach(System.out::println);

        Set<String> countriesSet = new LinkedHashSet<>(countriesList);
        System.out.println("__set begins__");
        countriesSet.stream().map(String::toLowerCase).forEach(System.out::println);*/

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        //intList.stream().filter(x->x<3).forEach(System.out::println);

        Optional<Integer> l = intList.stream().reduce(Integer::sum);


        int i = l.get() * 2;


        System.out.println(i);

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("apple", "orange"),
                Arrays.asList("banana", "grape", "kiwi"),
                Arrays.asList("cherry")
        );

        nestedList.forEach(innerList ->
                innerList.forEach(System.out::println)
        );

        nestedList.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        Integer[] arr = intList.toArray(new Integer[0]);
        List<Integer> newIntList = Arrays.asList(arr);


    }
}


