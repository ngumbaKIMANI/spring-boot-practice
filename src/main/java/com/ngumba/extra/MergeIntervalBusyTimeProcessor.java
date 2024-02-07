package com.ngumba.extra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


/*
You are given several log files that contains the execution intervals from all the jobs that are executed on the
server. We are interested in learning the times the system is busy. your task is to create a function that will process
all intervals found in the files and generate a consolidated out which will show the busy times of the system.

Assumption
- Assumed that the data has already been parsed and is in format that can be processed by your function.
- The parsed data is passed into the method that you create

Sample raw file data
1---5 10---17 37---43 5---7 3---8 19---21 27---32

Sample output that should be generated
1---8 10---17 19-21 27---43

*/
public class MergeIntervalBusyTimeProcessor {

    public static void main(String[] args) {
        // Sample raw file data
        List<String> rawData = new ArrayList<>();
        rawData.add("1---5");
        rawData.add("10---17");
        rawData.add("37---43");
        rawData.add("5---7");
        rawData.add("3---8");
        rawData.add("19---21");
        rawData.add("27---32");

        // Process and print the consolidated busy times
        //List<String> consolidatedBusyTimes = processIntervals(rawData);
        //System.out.println("Consolidated Busy Times: " + consolidatedBusyTimes);
        int[][] intervals = {{1, 5}, {10, 17}, {37, 43}, {5, 7}, {3, 8}, {19, 21}, {27, 32}};
        System.out.println(Arrays.deepToString(merge(intervals)));//[[1, 8], [10, 17], [19, 21], [27, 32], [37, 43]]
    }

    public static List<String> processIntervals(List<String> rawData) {
        List<Interval> intervals = new ArrayList<>();

        // Parse the raw data into Interval objects
        for (String intervalStr : rawData) {
            String[] parts = intervalStr.split("---");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            intervals.add(new Interval(start, end));
        }

        // Sort intervals based on start time
        Collections.sort(intervals);

        // Consolidate overlapping intervals
        List<Interval> consolidatedIntervals = new ArrayList<>();
        Interval currentInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextInterval = intervals.get(i);

            if (currentInterval.getEnd() >= nextInterval.getStart()) {
                // Overlapping intervals, merge them
                currentInterval.setEnd(Math.max(currentInterval.getEnd(), nextInterval.getEnd()));
            } else {
                // Non-overlapping interval, add the current one to the result
                consolidatedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        // Add the last interval
        consolidatedIntervals.add(currentInterval);

        // Convert consolidated intervals to strings
        List<String> result = new ArrayList<>();
        for (Interval interval : consolidatedIntervals) {
            result.add(interval.toString());
        }

        return result;
    }

    //method to read csv file
    public static List<String> readCsvFile1(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<String> readCSVFile2(String filePath) {
        Path path = Path.of(filePath);
        try {
            if (Files.exists(path)) {
                return Files.lines(path).skip(1).map(line -> {
                    String[] csvData = line.split(",");
                    return csvData[0] + "---" + csvData[1];
                }).toList();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    static class Interval implements Comparable<Interval> {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return start + "---" + end;
        }
    }
}
