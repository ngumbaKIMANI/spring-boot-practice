package com.ngumba.october;

import java.util.*;

public class Testing {
    public static void main(String[] args) {
        {
            int[] arrayWitTen = new int[10];

            int[] arrayWith100 = new int[100];
            arrayWitTen = arrayWith100;

            System.out.println(Arrays.toString(arrayWitTen));
            System.out.println(arrayWitTen.length);

            printMultiDimensionalArrayElements();
            fillArrayWithGivenValue();

            sortMultiDimensionalArray();

            sortString();

            printCountNumberOfTimesEachCharacterOccursInAWord();
        }
    }

    public static void copyArrayUsingForLoop(int[] source, int[] destination) {
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }

    public static void copyArrayUsingSystem(int[] source, int[] destination) {
        System.arraycopy(source, 0, destination, 0, source.length);
    }

    public static void copyArrayUsingArrayCopy(int[] source, int[] destination) {
        destination = Arrays.copyOf(source, source.length);
    }

    public static void copyArrayUsingClone(int[] source, int[] destination) {
        destination = source.clone();
    }

    public static void copyArrayUsingStream(int[] source, int[] destination) {
        destination = Arrays.stream(source).toArray();
    }

    public static void copyArrayUsingArraysCopyOfRange(int[] source, int[] destination) {
        destination = Arrays.copyOfRange(source, 0, source.length);
    }

    //use Arrays.equals() to compare two arrays
    public void compareTwoArrays() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        boolean equal = Arrays.equals(array1, array2);
        System.out.println(equal);
    }
    //use Arrays.deepEquals() to compare multidimensional arrays
    public void compareTwoMultiDimensionalArrays() {
        int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] array2 = {{1, 2, 3}, {4, 5, 6}};
        boolean equal = Arrays.deepEquals(array1, array2);
        System.out.println(equal);
    }
    //use Arrays.toString() to print array elements
    public void printArrayElements() {
        int[] array = {1, 2, 3};
        System.out.println(Arrays.toString(array));
    }
    //use forEach() to print array elements
    public void printArrayElementsUsingForEach() {
        int[] array = {1, 2, 3};
        Arrays.stream(array).forEach(System.out::println);
    }
    //use Arrays.deepToString() to print multidimensional array elements
    public static void printMultiDimensionalArrayElements() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(array));
    }
    //use Arrays.fill() to fill an array with a given value
    public static void fillArrayWithGivenValue() {
        int[] array = new int[10];
        Arrays.fill(array, 1);
        System.out.println(Arrays.toString(array));
    }

    //use Arrays.sort() to sort an array
    public static void sortArray() {
        int[] array = {3, 2, 1};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
    //sort a multidimensional array
    public static void sortMultiDimensionalArray() {
        int[][] array = {{3, 2, 1,5}, {6, 5, 4,7}};
        Arrays.sort(array, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(array));
    }

    // sort a string using arrays
    public static void sortString() {
        String[] array = {"c", "b", "a"};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    //sort a word using arrays
    public static void sortWord() {
        String word = "cba";
        char[] array = word.toCharArray();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    //print count number of times each character occurs in a word
    public static void printCountNumberOfTimesEachCharacterOccursInAWord() {
        String word = "abcdefghijklmnopqrstuvwxyz";
        char[] array = word.toCharArray();
        word.chars().forEach(System.out::println);
        for(char c : array) {
            System.out.println(c + " " + word.chars().filter(ch -> ch == c).count());
        }
    }

    //given a string, print its contents using chars() method
    public static void printStringContentsUsingCharsMethod() {
        String word = "cba";
        word.chars().forEach(System.out::println);
    }


    // length of longest substring without repeating characters using hashmap
    public static void lengthOfLongestSubstringWithoutRepeatingCharactersUsingHashMap() {
        String word = "abcabcbb";
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < word.length()) {
            char c = word.charAt(right);
            if(map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        System.out.println(max);
    }

    // length of longest substring without repeating characters and without nested loop
    public static void lengthOfLongestSubstringWithoutRepeatingCharactersWithoutNestedLoop() {
        String word = "abcabcbb";
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while(right < word.length()) {
            char c = word.charAt(right);
            if(set.contains(c)) {
                set.remove(word.charAt(left));
                left++;
            } else {
                set.add(c);
                max = Math.max(max, right - left + 1);
                right++;
            }
        }
        System.out.println(max);
    }

    // most efficient way to get length of longest substring without repeating characters
    public static void lengthOfLongestSubstringWithoutRepeatingCharactersMostEfficient() {
        String word = "abcabcbb";
        int left = 0;
        int right = 0;
        int max = 0;
        int[] array = new int[128];
        while(right < word.length()) {
            char c = word.charAt(right);
            left = Math.max(left, array[c]);
            array[c] = right + 1;
            max = Math.max(max, right - left + 1);
            right++;
        }
        System.out.println(max);
    }


    //use Arrays.parallelSort() to sort an array in parallel
    //use Arrays.binarySearch() to search for an element in a sorted array
    //use Arrays.parallelPrefix() to perform parallel prefix operation on an array
    //use Arrays.parallelSetAll() to set all elements of an array in parallel
    //use Arrays.setAll() to set all elements of an array
    //use Arrays.spliterator() to create a spliterator for an array
    //use Arrays.stream() to create a stream from an array
    //use Arrays.stream() to create a stream from a range of an array
    //use Arrays.stream() to create a stream from a range of an array with a given step
    //use Arrays.stream() to create a stream from a multidimensional array
    //use Arrays.stream() to create a stream from a multidimensional array with a given step


}
