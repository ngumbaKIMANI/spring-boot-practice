package com.ngumba.october;

import java.util.*;

public class Java8Streams {
    private static void testStreams() {
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

    private static void sortingArrays() {
        int[] arr1 = {1, 9, 0, 4, 1};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[][] arr2 = {{10, 2}, {1, 4}, {0, 4}, {4, 6}, {8, 0}};
        Arrays.sort(arr2, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(arr2));

        int[][] arr21 = {{10, 2}, {1, 4}, {0, 4}, {4, 6}, {8, 0}};
        Arrays.sort(arr21, (a, b) -> b[0] - a[0]);
        System.out.println(Arrays.deepToString(arr21));

        int[][] arr3 = {{10, 2}, {1, 4}, {0, 4}, {4, 6}, {8, 0}};
        Arrays.sort(arr3, (a, b) -> a[1] - b[1]);
        System.out.println(Arrays.deepToString(arr3));

        int[][] arr4 = {{1, 2}, {3, 4}, {5, 9}};
        Arrays.sort(arr4, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(arr4));

        int[][] arr5 = {{1, 2}, {3, 4}, {5, 9}};
        Arrays.sort(arr5, Comparator.comparingInt((int[] a) -> a[0]).reversed());
        System.out.println(Arrays.deepToString(arr5));


    }

    public static void main(String[] args) {
        //testStreams();
        sortingArrays();


    }
}


