package com.ngumba.october;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class StringManipulation1 {
    public static void main(String[] args) {
        //returnAllStringPermutationsMostEfficient("abc");
        // countNumberOfVowelsInStringMostEfficient();

        System.out.println(reverseString("he"));
    }

    //reverse string
    public static String reverseString(String str) {
        char[] charA = str.toCharArray();
        int l = str.length();

        StringBuilder newStr = new StringBuilder();
        for (int x = l - 1; x >= 0; x--) {
            newStr.append(str.charAt(x));
        }

        return newStr.toString();
    }

    // count number of vowels in a string using most efficient way
    public static void countNumberOfVowelsInStringMostEfficient() {
        String word = "aeiou";
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }

    // count number of vowels in a string using regex
    public static void countNumberOfVowelsInStringUsingRegex() {
        String word = "aeiou";
        int count = 0;
        for (char c : word.toCharArray()) {
            if (String.valueOf(c).matches("[aeiou]")) {
                count++;
            }
        }
        System.out.println(count);
    }

    //count number of times a character appears in a string using most efficient way
    public static void countNumberOfTimesACharacterAppearsInStringMostEfficient() {
        String word = "aaaaaabbccccmmm";
        char[] array = word.toCharArray();
        int[] count = new int[128];
        for (char c : array) {
            count[c]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println((char) i + " " + count[i]);
            }
        }
    }

    //check if a string is a palindrome using most efficient way
    public static void checkIfStringIsPalindromeMostEfficient() {
        String word = "racecar";
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                System.out.println("false");
                return;
            }
            left++;
            right--;
        }
        System.out.println("true");
    }

    // print fibbonacci sequence using most efficient way
    public static void printFibbonacciSequenceMostEfficient() {
        int n = 10;
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(a);
            c = a + b;
            a = b;
            b = c;
        }
    }

    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //You can return the answer in any order.
    public static int[] twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println(map.get(complement) + " " + i);
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    //two sum most efficient way
    public static int[] twoSumMostEfficient() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println(map.get(complement) + " " + i);
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    //two sum most efficient way using arrays only
    public static int[] twoSumMostEfficientUsingArraysOnly() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] array = new int[100];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (array[complement] != 0) {
                System.out.println(array[complement] + " " + i);
                return new int[]{array[complement], i};
            }
            array[nums[i]] = i;
        }
        return new int[]{};
    }

    //two sum most efficient way using arrays only avoiding out of bounds exception
    public static int[] twoSumMostEfficientUsingArraysOnlyAvoidingOutOfBounds() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] array = new int[100];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complement >= 0 && complement < array.length && array[complement] != 0) {
                System.out.println(array[complement] + " " + i);
                return new int[]{array[complement], i};
            }
            array[nums[i]] = i;
        }
        return new int[]{};
    }

    //return all string permutations using most efficient way
    public static void returnAllStringPermutationsMostEfficient(String word) {
        int n = word.length();
        char[] array = word.toCharArray();
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }
        System.out.println(word);
        int i = 0;
        while (i < n) {
            if (count[i] < i) {
                if (i % 2 == 0) {
                    swap(array, 0, i);
                } else {
                    swap(array, count[i], i);
                }
                System.out.println(String.valueOf(array));
                count[i]++;
                i = 0;
            } else {
                count[i] = 0;
                i++;
            }
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //Find All Permutations of given String Using Recursion and Loop
    public static void findAllPermutationsOfGivenStringUsingRecursionAndLoop(String word) {
        int n = word.length();
        char[] array = word.toCharArray();
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 0;
        }
        System.out.println(word);
        int i = 0;
        while (i < n) {
            if (count[i] < i) {
                if (i % 2 == 0) {
                    swap(array, 0, i);
                } else {
                    swap(array, count[i], i);
                }
                System.out.println(String.valueOf(array));
                count[i]++;
                i = 0;
            } else {
                count[i] = 0;
                i++;
            }
        }
    }

    public class Main {
        public static void main(String[] args) {
            returnAllStringPermutationsMostEfficient("abc");
        }
    }


}


class JavaMathExample1 {
    public static void main(String[] args) {
        double x = 28;
        double y = 4;

        // return the maximum of two numbers
        System.out.println("Maximum number of x and y is: " + Math.max(x, y));

        // return the square root of y
        System.out.println("Square root of y is: " + Math.sqrt(y));

        //returns 28 power of 4 i.e. 28*28*28*28
        System.out.println("Power of x and y is: " + Math.pow(x, y));

        // return the logarithm of given value
        System.out.println("Logarithm of x is: " + Math.log(x));
        System.out.println("Logarithm of y is: " + Math.log(y));

        // return the logarithm of given value when base is 10
        System.out.println("log10 of x is: " + Math.log10(x));
        System.out.println("log10 of y is: " + Math.log10(y));

        // return the log of x + 1
        System.out.println("log1p of x is: " + Math.log1p(x));

        // return a power of 2
        System.out.println("exp of a is: " + Math.exp(x));

        // return (a power of 2)-1
        System.out.println("expm1 of a is: " + Math.expm1(x));
    }
}

// The ThreadJoin class is the child class of the class Thread
class ThreadJoin extends Thread {
    // overriding the run method
    public void run() {
        for (int j = 0; j < 2; j++) {
            try {
// sleeping the thread for 300 milli seconds
                Thread.sleep(300);
                System.out.println("The current thread name is: " + Thread.currentThread().getName());
            }
// catch block for catching the raised exception
            catch (Exception e) {
                System.out.println("The exception has been caught: " + e);
            }
            System.out.println(j);
        }
    }
}

class ThreadJoinExample {
    // main method
    public static void main(String argvs[]) {

// creating 3 threads
        ThreadJoin th1 = new ThreadJoin();
        ThreadJoin th2 = new ThreadJoin();
        ThreadJoin th3 = new ThreadJoin();

// thread th1 starts
        th1.start();

// starting the second thread after when
// the first thread th1 has ended or died.
        try {
            System.out.println("The current thread name is: " + Thread.currentThread().getName());

// invoking the join() method
            th1.join();
        }

// catch block for catching the raised exception
        catch (Exception e) {
            System.out.println("The exception has been caught " + e);
        }

// thread th2 starts
        th2.start();

// starting the th3 thread after when the thread th2 has ended or died.
        try {
            System.out.println("The current thread name is: " + Thread.currentThread().getName());
            th2.join();
        }

// catch block for catching the raised exception
        catch (Exception e) {
            System.out.println("The exception has been caught " + e);
        }

// thread th3 starts
        th3.start();
    }
}

class TestMultitasking1 extends Thread {
    public static void main(String args[]) {
        TestMultitasking1 t1 = new TestMultitasking1();
        TestMultitasking1 t2 = new TestMultitasking1();
        TestMultitasking1 t3 = new TestMultitasking1();

        t1.start();
        t2.start();
        t3.start();
    }

    public void run() {
        System.out.println("task one");
    }
}

class TestMultitasking2 implements Runnable {
    public static void main(String args[]) {
        Thread t1 = new Thread(new TestMultitasking2());//passing annonymous object of TestMultitasking2 class
        Thread t2 = new Thread(new TestMultitasking2());

        t1.start();
        t2.start();

    }

    public void run() {
        System.out.println("task one");
    }


    class PredicateExample {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

            // Create a Predicate to filter even numbers
            Predicate<Integer> isEven = num -> num % 2 == 0;

            // Use the Predicate to filter the list
            numbers.removeIf(isEven);

            System.out.println(numbers); // Output: [1, 3, 5, 7, 9]
        }
    }

}
